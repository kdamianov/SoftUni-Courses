package com.example.cardealer.repositories;

import com.example.cardealer.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
