package com.example.car_rent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientErrorType {

    NOT_FOUND("Клиентът не е намерен.", 404),
    INVALID_DATA("Невалидни данни за клиент.", 400);

    private final String message;
    private final int status;

}
