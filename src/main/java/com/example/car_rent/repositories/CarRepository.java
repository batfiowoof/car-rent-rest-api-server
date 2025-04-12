package com.example.car_rent.repositories;

import com.example.car_rent.entities.Car;
import com.example.car_rent.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByCity(City city);

    Car findById(int id);

    Car updateCar(int id, Car car);

    void deleteById(int id);

}
