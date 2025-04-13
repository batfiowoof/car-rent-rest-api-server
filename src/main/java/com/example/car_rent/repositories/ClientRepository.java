package com.example.car_rent.repositories;

import com.example.car_rent.entities.Client;
import com.example.car_rent.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    City findLocationById(int clientId);
}
