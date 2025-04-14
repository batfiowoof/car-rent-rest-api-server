package com.example.car_rent.repositories;

import com.example.car_rent.entities.Client;
import com.example.car_rent.enums.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    City findLocationById(int clientId);

    @Override
    @Query("SELECT c FROM Client c WHERE c.deleted = false")
    List<Client> findAll();

    @Modifying
    @Query("UPDATE Client c SET c.deleted = true WHERE c.id = :id")
    void delete(int id);
}
