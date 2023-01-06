package magicGame.repositories;

import magicGame.models.magicians.Magician;
import magicGame.repositories.interfaces.MagicianRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private List<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return data.remove(magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream()
                .filter(magician -> magician.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
