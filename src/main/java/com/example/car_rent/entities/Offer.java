package com.example.car_rent.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offer")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="has_accidents")
    private boolean hasAccidents;

    @Column(name="car_id")
    private Long carId; // FK към Car

    private int days;
    private double price;
    private String status;
    private boolean deleted;
}
