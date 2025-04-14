package com.example.car_rent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum CarErrorType {
    NOT_FOUND("Car not found",404),
    INVALID_CAR("Invalid car",400),
    INVALID_CITY("Invalid city",400),
    DUPLICATE_CAR("Duplicate car",409);

    private final String message;
    private final int status;

}
