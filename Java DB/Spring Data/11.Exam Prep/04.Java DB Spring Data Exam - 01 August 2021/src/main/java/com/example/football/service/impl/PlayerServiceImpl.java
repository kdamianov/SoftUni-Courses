package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImportWrapperDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtilsImpl;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.example.football.models.Constant.*;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYERS_FILE_PATH = "skeleton/src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository, ValidationUtilsImpl validationUtils,
                             ModelMapper modelMapper,
                             XmlParser xmlParser) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        final StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(Path.of(PLAYERS_FILE_PATH).toFile(), PlayerImportWrapperDto.class)
                .getPlayers()
                .stream()
                .filter(pLayerImportDto -> {
                    boolean isValid = validationUtils.isValid(pLayerImportDto);
                    boolean isPlayersEmailPresent = playerRepository.findByEmail(pLayerImportDto.getEmail()).isPresent();

                    if (isPlayersEmailPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT_PLAYERS, PLAYER,
                            pLayerImportDto.getFirstName(),
                            pLayerImportDto.getLastName(),
                            pLayerImportDto.getPosition())
                            : String.format(INVALID_FORMAT, PLAYER))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(pLayerImportDto -> {
                    Player player = modelMapper.map(pLayerImportDto, Player.class);
                    player.setTown(townRepository.findByName(pLayerImportDto.getTown().getName()).orElse(null));
                    player.setTeam(teamRepository.findByName(pLayerImportDto.getTeam().getName()).orElse(null));
                    player.setStat(statRepository.findById(pLayerImportDto.getStat().getId()).orElse(null));

                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        final StringBuilder sb = new StringBuilder();
        List<Player> playersByBirthdayBetween = playerRepository.findByBirthDateBetweenOrderByStat_ShootingDescStat_PassingDescStat_EnduranceDescLastName(
                LocalDate.parse("01/01/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.parse("01/01/2003", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        playersByBirthdayBetween.
                forEach(player -> sb.append(String.format("Player - %s %s\n" +
                        "\tPosition - %s\n" +
                        "\tTeam - %s\n" +
                        "\tStadium - %s\n",
                        player.getFirstName(),
                        player.getLastName(),
                        player.getPosition(),
                        player.getTeam().getName(),
                        player.getTeam().getStadiumName()
                        )));

        return sb.toString().trim();

    }
}
