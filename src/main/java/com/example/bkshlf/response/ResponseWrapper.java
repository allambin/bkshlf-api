package com.example.bkshlf.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponseWrapper
{
    private String key;
    private Object data;

    // Constructor, getters, and setters
}

