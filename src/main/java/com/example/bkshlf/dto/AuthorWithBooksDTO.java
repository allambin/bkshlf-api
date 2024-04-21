package com.example.bkshlf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorWithBooksDTO
{
    private String id;
    private String name;
    private Set<BookDTO> books;
}
