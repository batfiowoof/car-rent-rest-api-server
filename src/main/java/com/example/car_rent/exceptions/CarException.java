package com.example.car_rent.exceptions;

import com.example.car_rent.enums.CarErrorType;

public class CarException extends RuntimeException {

    private final CarErrorType errorType;

    public CarException(CarErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CarErrorType getErrorType() {
        return errorType;
    }

}
