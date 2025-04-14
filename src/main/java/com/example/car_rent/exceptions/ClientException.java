package com.example.car_rent.exceptions;

import com.example.car_rent.enums.ClientErrorType;
import lombok.Getter;

@Getter
public class ClientException extends RuntimeException {

    private final ClientErrorType errorType;

    public ClientException(ClientErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
