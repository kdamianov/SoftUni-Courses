package com.example.cardealer.service;

import com.example.cardealer.model.dto.carsDto.CarPartsListDto;
import com.example.cardealer.model.dto.carsDto.CarToyotaDto;
import com.example.cardealer.model.entities.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {
    void seedCars() throws IOException;

    Car findRandomCar();

    List<CarToyotaDto> getAllCarsFromMakeToyota(String make);

    List<CarPartsListDto> getAllCarsWithTheirListOfParts();
}
