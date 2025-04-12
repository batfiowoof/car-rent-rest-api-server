package com.example.car_rent.repositories;

import com.example.car_rent.entities.Car;
import com.example.car_rent.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByLocation(City location);

    // find, save методите не са нужни, защото JpaRepository ги има, delete метода също

}
