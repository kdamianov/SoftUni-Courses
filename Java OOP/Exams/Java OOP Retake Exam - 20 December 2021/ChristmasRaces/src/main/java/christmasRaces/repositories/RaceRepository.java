package christmasRaces.repositories;


import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class RaceRepository implements Repository<Race> {
    private Race race;
    private Map<String, Race> races;

    public RaceRepository() {
        this.races = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return races.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races.values());
    }

    @Override
    public void add(Race race) {
        this.races.putIfAbsent(race.getName(), race);
    }

    @Override
    public boolean remove(Race race) {
        return this.races.remove(race.getName()) != null;
    }
}
