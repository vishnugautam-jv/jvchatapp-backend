package com.jvgroup.jvchatapp.controller;

import com.jvgroup.jvchatapp.entity.CustomErrorResponse;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// The @ControllerAdvice annotation is used to define a class that will be called whenever an exception is thrown in your application.
// This class can contain multiple methods, each of which is annotated with the @ExceptionHandler annotation and is responsible for handling a specific exception.
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc){

        HttpStatus status;

        if(exc instanceof TypeMismatchException){
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        CustomErrorResponse error = new CustomErrorResponse(status, exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, status);
    }


}
