package com.example.car_rent.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private int statusCode;
    private LocalDateTime dateTime;

    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.dateTime = LocalDateTime.now();
    }

}
