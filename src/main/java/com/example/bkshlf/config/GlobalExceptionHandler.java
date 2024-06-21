package com.example.bkshlf.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @Value("${spring.profiles.active}")
    private String activeProfile;

    private ErrorResponse createErrorResponse(String message, HttpStatus status, Exception ex)
    {
        ErrorResponse e = new ErrorResponse();
        e.setMessage(message);
        e.setHttpStatus(status.value());
        if (!"prod".equals(activeProfile)) {
            e.setDebugMessage(ex.getMessage());
        }
        return e;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex)
    {
        ErrorResponse e = createErrorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorResponse> handleRestException(RestException ex)
    {
        ErrorResponse e = createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return new ResponseEntity<>(e, ex.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex)
    {
        ErrorResponse e = createErrorResponse("Missing body", HttpStatus.BAD_REQUEST, ex);
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        ErrorResponse e = createErrorResponse("Invalid argument", HttpStatus.BAD_REQUEST, ex);
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException ex)
    {
        ErrorResponse e = createErrorResponse("Bad credentials", HttpStatus.BAD_REQUEST, ex);
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
