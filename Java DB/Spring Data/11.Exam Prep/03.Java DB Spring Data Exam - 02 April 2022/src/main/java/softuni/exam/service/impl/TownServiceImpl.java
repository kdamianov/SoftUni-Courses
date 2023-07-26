package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service

public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils,
                           Gson gson) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(readTownsFileContent(), TownImportDto[].class))
                .filter(townImportDto -> {
                    boolean isValid = validationUtils.isValid(townImportDto);
                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_TOWNS, TOWN, townImportDto.getTownName(), townImportDto.getPopulation())
                                    : String.format(INVALID_FORMAT, TOWN))
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(townImportDto -> modelMapper.map(townImportDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString().trim();
    }
}
