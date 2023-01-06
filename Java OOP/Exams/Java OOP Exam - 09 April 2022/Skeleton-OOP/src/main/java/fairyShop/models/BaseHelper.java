package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static fairyShop.common.ExceptionMessages.*;

public abstract class BaseHelper implements Helper{
    private String name;
    private int energy;
    private List<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        this.setName(name);
        this.energy = energy;
        this.instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        if (this.energy - 10 < 0) {
            this.energy = 0;
        } else {
            this.energy -= 10;
        }
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }
}
