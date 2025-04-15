package com.example.car_rent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OfferErrorType {

    NOT_FOUND("Офертата не е намерена.", 404),
    INVALID_DATA("Невалидни данни за оферта.", 400),
    INVALID_DATE("Невалидна дата.", 400),
    INVALID_PRICE("Невалидна цена.", 400),
    INVALID_CAR_ID("Невалиден идентификатор на кола.", 400),
    INVALID_CLIENT_ID("Невалиден идентификатор на клиент.", 400);

    private final String message;
    private final int status;

}
