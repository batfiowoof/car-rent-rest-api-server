package com.example.car_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {
    private int id;
    private String clientName;
    private String carBrand;
    private String carModel;
    private double dailyPrice;
    private String location; // City
    private int days;
    private double totalPrice;
}
