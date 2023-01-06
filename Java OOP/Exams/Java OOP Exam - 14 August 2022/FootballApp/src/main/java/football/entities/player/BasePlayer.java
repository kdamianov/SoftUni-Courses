package football.entities.player;

import football.common.ExceptionMessages;

import static football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        this.name = name;
        this.nationality = nationality;
        this.kg = kg;
        this.strength = strength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (ifNullOrWhiteSpace(name)) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    protected void setNationality(String nationality) {
        if (ifNullOrWhiteSpace(nationality)) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }

        this.nationality = nationality;
    }

    @Override
    public double getKg() {
        return kg;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    protected void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }

        this.strength = strength;
    }

    @Override
    public void stimulation() {

    }

    private boolean ifNullOrWhiteSpace(String name){
        return name == null || name.trim().isEmpty();
    }
}
