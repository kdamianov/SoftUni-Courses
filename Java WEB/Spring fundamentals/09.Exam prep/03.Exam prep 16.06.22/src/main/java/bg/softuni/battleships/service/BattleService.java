package bg.softuni.battleships.service;

import bg.softuni.battleships.models.dto.StartBattleDTO;

public interface BattleService {

    void attack(StartBattleDTO startBattleDTO);
}
