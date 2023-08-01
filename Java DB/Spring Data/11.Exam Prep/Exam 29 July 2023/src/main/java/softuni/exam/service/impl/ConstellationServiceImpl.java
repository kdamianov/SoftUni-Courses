package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private static final String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";
    private final ConstellationRepository constellationRepository;
    final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ValidationUtilsImpl validationUtils, ModelMapper modelMapper, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        final StringBuilder sb = new StringBuilder();

        Arrays.stream(this.gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class))
                .filter(constellationImportDto -> {
                    boolean isValid = this.validationUtils.isValid(constellationImportDto);
                    boolean isConstellationPresent = this.constellationRepository
                            .findByName(constellationImportDto.getName()).isPresent();

                    if (isConstellationPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_CONSTELLATIONS, CONSTELLATION,
                                    constellationImportDto.getName(), constellationImportDto.getDescription())
                                    : String.format(INVALID_FORMAT, CONSTELLATION))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(constellationImportDto -> modelMapper.map(constellationImportDto, Constellation.class))
                .forEach(constellationRepository::save);

        return sb.toString().trim();
    }
}
