package com.example.car_rent.exceptions;

import com.example.car_rent.enums.CarErrorType;
import com.example.car_rent.enums.ClientErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        // Log the exception
        e.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CarException.class)
    public ResponseEntity<ErrorResponse> handleCarException(CarException ex) {
        CarErrorType type = ex.getErrorType();

        ErrorResponse error = new ErrorResponse(
                type.getMessage(),
                type.getStatus()
        );

        return new ResponseEntity<>(error, HttpStatus.valueOf(type.getStatus()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable() {
        ErrorResponse error = new ErrorResponse(
                "Invalid data in JSON request",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ErrorResponse> handleClientException(ClientException ex) {
        ClientErrorType type = ex.getErrorType();

        ErrorResponse error = new ErrorResponse(
                type.getMessage(),
                type.getStatus()
        );

        return new ResponseEntity<>(error, HttpStatus.valueOf(type.getStatus()));
    }

}
