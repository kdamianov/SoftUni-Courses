package com.example.cardealer.service.impl;


import com.example.cardealer.repository.CarRepository;
import com.example.cardealer.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public long getCount() {
        return carRepository.count();
    }
}
