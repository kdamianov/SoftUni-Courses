package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ExceptionMessages.*;

public abstract class BaseDiscoverer implements Discoverer{
    private static final int DEFAULT_ENERGY_DECREASE = 15;
    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    @Override
    public void dig() {
        this.energy = Math.max(0, this.energy - DEFAULT_ENERGY_DECREASE);
    }
}
