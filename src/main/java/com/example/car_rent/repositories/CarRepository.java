package com.example.car_rent.repositories;

import com.example.car_rent.entities.Car;
import com.example.car_rent.enums.City;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByLocation(City location);

    // find, save методите не са нужни, защото JpaRepository ги има

    @Override
    @Query("SELECT c FROM Car c WHERE c.deleted = false")
    List<Car> findAll();

    //soft delete
    @Modifying
    @Query("UPDATE Car c SET c.deleted = true WHERE c.id = :id")
    @Transactional
     void delete(int id);
}
