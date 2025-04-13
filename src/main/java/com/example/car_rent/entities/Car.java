package com.example.car_rent.entities;

import com.example.car_rent.enums.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor ако е нужно конструктори с параметри
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private City location;

    @Column(name = "deleted")
    private boolean deleted;

}
