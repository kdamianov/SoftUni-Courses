package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarExportDto;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.Constants.*;

@Service
public class StarServiceImpl implements StarService {
    private static final String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final ValidationUtils validationUtils;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public StarServiceImpl(StarRepository starRepository,
                           ConstellationRepository constellationRepository,
                           ValidationUtils validationUtils,
                           Gson gson,
                           ModelMapper modelMapper) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.validationUtils = validationUtils;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readStarsFileContent(), StarImportDto[].class))
                .filter(starImportDto -> {
                    boolean isValid = validationUtils.isValid(starImportDto);
                    Optional<Star> starByName = starRepository.findByName(starImportDto.getName());

                    if (starByName.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_STARS, STAR,
                                    starImportDto.getName(), starImportDto.getLightYears())
                                    : String.format(INVALID_FORMAT, STAR))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(starImportDto -> {
                    Star star = modelMapper.map(starImportDto, Star.class);
                    star.setConstellation(constellationRepository.getById(starImportDto.getConstellation()));

                    return star;
                })
                .forEach(starRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportStars() {
        final StringBuilder sb = new StringBuilder();
        List<StarExportDto> allStarsByType = this.starRepository.findAllStarsByType();

        allStarsByType.forEach(star -> {
            sb.append(String.format("Star: %s%n" +
                            "   *Distance: %.2f light years%n" +
                            "   **Description: %s%n" +
                            "   ***Constellation: %s%n",
                    star.getName(),
                    star.getLightYears(),
                    star.getDescription(),
                    star.getConstellationName()
            ));
        });


        return sb.toString().trim();
    }
}
