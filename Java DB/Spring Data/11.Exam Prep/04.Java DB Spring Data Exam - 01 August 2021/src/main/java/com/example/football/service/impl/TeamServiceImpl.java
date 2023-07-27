package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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

public class TeamServiceImpl implements TeamService {
    private static final String TEAMS_FILE_PATH = "skeleton/src/main/resources/files/json/teams.json";
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, ValidationUtilsImpl validationUtils, ModelMapper modelMapper, Gson gson) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(readTeamsFileContent(), TeamImportDto[].class))
                .filter(teamImportDto -> {
                    boolean isValid = validationUtils.isValid(teamImportDto);
                    boolean isTeamPresent = teamRepository.findByName(teamImportDto.getName()).isPresent();

                    if (isTeamPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_TEAMS, TEAM,
                                    teamImportDto.getName(), teamImportDto.getFanBase())
                                    : String.format(INVALID_FORMAT, TEAM))
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(teamImportDto -> {
                    Team team = modelMapper.map(teamImportDto, Team.class);
                    team.setTown(townRepository.findByName(teamImportDto.getTownName()).orElse(null));
                    return team;
                })
                .forEach(teamRepository::save);

        return sb.toString().trim();
    }
}
