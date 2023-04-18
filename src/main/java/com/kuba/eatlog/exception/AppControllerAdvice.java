package com.kuba.eatlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(){
        String exceptionMessage = "Resource not found";
        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }
}
