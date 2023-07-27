package com.example.football.service.impl;

import com.example.football.models.dto.StatImportDto;
import com.example.football.models.dto.StatImportWrapperDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtilsImpl;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.models.Constant.*;

@Service

public class StatServiceImpl implements StatService {
    private static final String STATS_FILE_PATH = "skeleton/src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ValidationUtilsImpl validationUtils, ModelMapper modelMapper, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        final StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(Path.of(STATS_FILE_PATH).toFile(), StatImportWrapperDto.class)
                .getStats()
                .stream()
                .filter(statImportDto -> {
                    boolean isValid = validationUtils.isValid(statImportDto);
                    boolean isStatPresent = statRepository.findByPassingAndShootingAndEndurance(
                            statImportDto.getPassing(),
                            statImportDto.getShooting(),
                            statImportDto.getEndurance()
                    ).isPresent();

                    if (isStatPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_STATS, STAT,
                                    statImportDto.getPassing(),
                                    statImportDto.getShooting(),
                                    statImportDto.getEndurance())
                                    : String.format(INVALID_FORMAT, STAT))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(statImportDto -> modelMapper.map(statImportDto, Stat.class))
                .forEach(statRepository::save);

        return sb.toString().trim();
    }
}
