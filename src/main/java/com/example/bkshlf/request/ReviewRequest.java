package com.example.bkshlf.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest
{
    @NotEmpty(message = "The content is required.")
    private String content;
    private long editionId;
}
