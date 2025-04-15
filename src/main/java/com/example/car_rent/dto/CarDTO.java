package com.example.car_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private int id;
    private String brand;
    private String model;
    private double dailyPrice;
    private String location; // City
}
