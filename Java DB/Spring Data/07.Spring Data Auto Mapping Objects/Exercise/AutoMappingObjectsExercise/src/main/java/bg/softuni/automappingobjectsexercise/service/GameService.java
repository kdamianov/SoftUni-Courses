package bg.softuni.automappingobjectsexercise.service;

import bg.softuni.automappingobjectsexercise.model.dto.GameAddDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGame(Long gameId);
}
