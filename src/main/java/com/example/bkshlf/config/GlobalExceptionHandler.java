package com.example.bkshlf.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(RestException.class)
    public ResponseEntity<RestException> handleRestException(RestException ex)
    {
        return new ResponseEntity<>(ex, ex.getHttpStatus());
    }
}
