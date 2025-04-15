package com.example.car_rent.mappers;

import com.example.car_rent.dto.CarDTO;
import com.example.car_rent.entities.Car;

public class CarMapper {

    public static CarDTO toDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .dailyPrice(car.getDailyPrice())
                .location(car.getLocation().name())
                .build();
    }
}
