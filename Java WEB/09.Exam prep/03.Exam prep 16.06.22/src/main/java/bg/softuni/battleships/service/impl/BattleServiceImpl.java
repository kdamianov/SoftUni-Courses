package bg.softuni.battleships.service.impl;

import bg.softuni.battleships.models.dto.StartBattleDTO;
import bg.softuni.battleships.models.entity.Ship;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.service.BattleService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleServiceImpl implements BattleService {
    private ShipRepository shipRepository;

    public BattleServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void attack(StartBattleDTO startBattleDTO) {
        Optional<Ship> attackerOpt = this.shipRepository.findById(startBattleDTO.getAttackerId());
        Optional<Ship> defenderOpt = this.shipRepository.findById(startBattleDTO.getDefenderId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = attackerOpt.get();
        Ship defender = defenderOpt.get();

        long defenderNewHealth = defender.getHealth() - attacker.getPower();

        if (defenderNewHealth <= 0) {
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(defenderNewHealth);
            this.shipRepository.save(defender);
        }
    }
}
