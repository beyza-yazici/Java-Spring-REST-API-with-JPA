package com.workintech.fswebs18challengemaven.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(CardException exception){
        log.error("Error occurred: ", exception);
        CardErrorResponse burgerErrorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(Exception exception){
        log.error("Unexpected error occurred: ", exception);
        CardErrorResponse burgerErrorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
