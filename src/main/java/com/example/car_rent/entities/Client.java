package com.example.car_rent.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Client {

    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="client_name")
    private String name;

    @Column(name="client_address")
    private String address;

    @Column(name="client_phone")
    private String phone;

    @Column(name="client_age")
    private int age;

}
