package com.example.car_rent.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="has_accidents")
    private boolean hasAccidents;

    @Column(name="car_id")
    private int carId; // FK към Car

    @Column(name="client_id")
    private int clientId; // FK към Client

    @Column(name = "days")
    private int days;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted")
    private boolean deleted;
}
