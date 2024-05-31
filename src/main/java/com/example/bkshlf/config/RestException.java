package com.example.bkshlf.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed", "localizedMessage"})
public class RestException extends RuntimeException
{
    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public RestException() {
        this.timestamp = LocalDateTime.now();
    }

    public RestException(HttpStatus httpStatus, String message) {
        this();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public RestException(HttpStatus httpStatus, String message, Throwable ex) {
        this();
        this.message = message;
        this.httpStatus = httpStatus;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
