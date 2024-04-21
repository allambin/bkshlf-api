package com.example.bkshlf.config;

public class RequestError
{
    private String message;

    public RequestError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
