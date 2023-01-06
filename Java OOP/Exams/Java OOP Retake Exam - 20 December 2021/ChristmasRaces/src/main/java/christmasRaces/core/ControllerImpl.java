package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;


    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = new DriverRepository();
        this.carRepository = new CarRepository();
        this.raceRepository = new RaceRepository();
    }

    @Override
    public String createDriver(String driverName) {
        Driver driver;
        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driverName));
        }
        driver = new DriverImpl(driverName);
        driverRepository.add(driver);
        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        carRepository.add(car);

        return String.format(CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car car = carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Driver driver = driverRepository.getByName(driverName);
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String raceName, int laps) {
        Race race = raceRepository.getByName(raceName);
        if (race != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, raceName));
        }

        Race newRace = new RaceImpl(raceName, laps);
        raceRepository.add(newRace);

        return String.format(RACE_CREATED, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> winners = race.getDrivers()
                .stream()
                .sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(race.getLaps()),
                        d1.getCar().calculateRacePoints(race.getLaps())))
                .limit(3)
                .collect(Collectors.toList());

        raceRepository.remove(race);
        Driver firstDriver = winners.get(0);
        Driver secondDriver = winners.get(1);
        Driver thirddDriver = winners.get(2);



        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DRIVER_FIRST_POSITION,firstDriver.getName(), raceName))
                .append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION,secondDriver.getName(), raceName))
                .append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION,thirddDriver.getName(), raceName));

        return sb.toString().trim();
    }


}
