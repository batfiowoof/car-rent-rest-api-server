package com.example.car_rent.repositories;

import com.example.car_rent.entities.Car;
import com.example.car_rent.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

    List<Offer> findByClientId(Car car);
}
