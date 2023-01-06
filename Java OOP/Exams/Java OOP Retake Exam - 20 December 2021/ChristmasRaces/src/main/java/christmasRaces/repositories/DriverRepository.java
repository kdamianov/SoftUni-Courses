package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DriverRepository implements Repository<Driver> {
    private Driver driver;
    private Map<String, Driver> drivers;

    public DriverRepository() {
        this.drivers = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return drivers.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.drivers.values());
    }

    @Override
    public void add(Driver driver) {
        this.drivers.putIfAbsent(driver.getName(), driver);
    }

    @Override
    public boolean remove(Driver driver) {
        return this.drivers.remove(driver.getName()) != null;
    }
}
