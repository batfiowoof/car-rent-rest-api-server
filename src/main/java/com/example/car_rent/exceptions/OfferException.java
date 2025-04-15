package com.example.car_rent.exceptions;

import com.example.car_rent.enums.OfferErrorType;
import lombok.Getter;

@Getter
public class OfferException extends RuntimeException {

    private final OfferErrorType errorType;

    public OfferException(OfferErrorType errorType) {
        super(errorType.toString());
        this.errorType = errorType;
    }
}
