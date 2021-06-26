package com.spaceiq.bookingdeskservice.controller;

import com.spaceiq.bookingdeskservice.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<CustomErrorResponse> outOfRangeExceptionHandler(IllegalArgumentException e) {
        System.out.println("Ruh roh " +  e.getMessage());
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.toString());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}
