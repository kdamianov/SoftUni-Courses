package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtilsImpl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.football.models.Constant.*;



@Service

public class TownServiceImpl implements TownService {
    private static final String TOWNS_PATH = "skeleton/src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository,
                           ValidationUtilsImpl validationUtils,
                           ModelMapper modelMapper,
                           Gson gson) {
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        final StringBuilder sb = new StringBuilder();

        Arrays.stream(this.gson.fromJson(readTownsFileContent(), TownImportDto[].class))
                .filter(townImportDto -> {
                    boolean isValid = validationUtils.isValid(townImportDto);

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_TOWNS, TOWN,
                                    townImportDto.getName(), townImportDto.getPopulation())
                                    : String.format(INVALID_FORMAT, TOWN))
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(townImportDto -> modelMapper.map(townImportDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString().trim();
    }
}
