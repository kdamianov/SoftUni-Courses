package bg.softuni.automappingobjectsexercise.service;

import bg.softuni.automappingobjectsexercise.model.dto.GameDetailDto;
import bg.softuni.automappingobjectsexercise.model.dto.GamesAllDto;
import bg.softuni.automappingobjectsexercise.model.dto.GameAddDto;

import java.math.BigDecimal;
import java.util.List;


public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(Long gameId);

    List<GamesAllDto> printAllGames();

    GameDetailDto printGameDetails(String title);
}
