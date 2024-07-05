package com.example.bkshlf.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShelfRequest
{
    @NotEmpty(message = "The name is required.")
    private String name;
}
