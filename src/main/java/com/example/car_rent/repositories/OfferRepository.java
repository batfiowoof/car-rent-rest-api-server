package com.example.car_rent.repositories;

import com.example.car_rent.entities.Car;
import com.example.car_rent.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

    List<Offer> findAllByClientId(int clientId);

    @Modifying
    @Query("UPDATE Offer o SET o.status = 'accepted' WHERE o.id = :id")
    void acceptOffer(@Param("id") int id);

    @Override
    @Query("SELECT o FROM Offer o WHERE o.deleted = false")
    List<Offer> findAll();

    @Modifying
    @Query("UPDATE Offer o SET o.deleted = true WHERE o.id = :id")
    void delete(int id);
}
