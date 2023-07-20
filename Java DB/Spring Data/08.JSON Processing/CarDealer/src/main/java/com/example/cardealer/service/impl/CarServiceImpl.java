package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.carsDto.CarPartsListDto;
import com.example.cardealer.model.dto.carsDto.CarSeedDto;
import com.example.cardealer.model.dto.carsDto.CarToyotaDto;
import com.example.cardealer.model.entities.Car;
import com.example.cardealer.repositories.CarRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.PartService;
import com.example.cardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.cardealer.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class CarServiceImpl implements CarService {
    private static final String CARS_FILE = "cars.json";
    private final Gson gson;
    private final CarRepository carRepository;
    private final PartService partService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CarServiceImpl(Gson gson, CarRepository carRepository, PartService partService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gson = gson;
        this.carRepository = carRepository;
        this.partService = partService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedCars() throws IOException {
        if (carRepository.count() > 0) {
            return;
        }

        String content = Files.readString(Path.of(RESOURCES_FILES_PATH + CARS_FILE));

        CarSeedDto[] carSeedDtos = gson.fromJson(content, CarSeedDto[].class);

        Arrays.stream(carSeedDtos)
                .filter(validationUtil::isValid)
                .map(carSeedDto -> {
                    Car car = modelMapper.map(carSeedDto, Car.class);
                    car.setParts(partService.findRandomPart()); //add between 3 and 5 random parts
                    return car;
                })
                .forEach(carRepository::save);
    }
    @Override
    public Car findRandomCar() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, carRepository.count() + 1);

        return carRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<CarToyotaDto> getAllCarsFromMakeToyota(String make) {
        return carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
                .stream()
                .filter(validationUtil::isValid)
                .map(car -> modelMapper.map(car, CarToyotaDto.class))
                .toList();
    }

    @Override
    public List<CarPartsListDto> getAllCarsWithTheirListOfParts() {
        return carRepository
                .findAll()
                .stream()
                .filter(validationUtil::isValid)
                .map(car -> modelMapper.map(car, CarPartsListDto.class))
                .toList();

    }
}
