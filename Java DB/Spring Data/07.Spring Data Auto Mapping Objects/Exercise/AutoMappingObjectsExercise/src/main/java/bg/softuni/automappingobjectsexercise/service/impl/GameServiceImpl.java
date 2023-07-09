package bg.softuni.automappingobjectsexercise.service.impl;

import bg.softuni.automappingobjectsexercise.model.dto.GameDetailDto;
import bg.softuni.automappingobjectsexercise.model.dto.GamesAllDto;
import bg.softuni.automappingobjectsexercise.model.dto.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.entities.Game;
import bg.softuni.automappingobjectsexercise.repository.GameRepository;
import bg.softuni.automappingobjectsexercise.service.GameService;
import bg.softuni.automappingobjectsexercise.service.UserService;
import bg.softuni.automappingobjectsexercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper mapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        //1.Проверка за нарушения
        Set<ConstraintViolation<GameAddDto>> violations =
                validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = mapper.map(gameAddDto, Game.class);
        game.setReleaseDate(LocalDate.parse(gameAddDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        gameRepository.save(game);
        System.out.printf("Added %s%n", gameAddDto.getTitle());

    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId)
                .orElse(null);

        if (game == null) {
            System.out.printf("No such game with ID: %d%n", gameId);
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game); //запазваме новата информация

        System.out.printf("Edited %s%n", game.getTitle());
    }

    @Override
    public void deleteGame(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElse(null);

        if (game == null) {
            System.out.printf("No such game with ID: %d%n", gameId);
            return;
        }

        System.out.printf("Deleted %s%n", game.getTitle());
        gameRepository.delete(game); //изтрива дадените данни
    }

    @Override
    public List<GamesAllDto> printAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(game -> mapper.map(game, GamesAllDto.class))
                .toList();
    }

    @Override
    public GameDetailDto printGameDetails(String title) {
        Game game = gameRepository.findGameByTitle(title);
        GameDetailDto gameDetailDto = null;

        if (game != null) {
            gameDetailDto = mapper.map(game, GameDetailDto.class);
        }

        return gameDetailDto;
    }
}
