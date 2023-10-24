package bg.softuni.battleships.models.dto;

import jakarta.validation.constraints.Positive;

public class StartBattleDTO {
    @Positive
    private long attackerId;
    @Positive
    private long defenderId;

    public StartBattleDTO() {
    }

    public long getAttackerId() {
        return attackerId;
    }

    public StartBattleDTO setAttackerId(long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public long getDefenderId() {
        return defenderId;
    }

    public StartBattleDTO setDefenderId(int defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
