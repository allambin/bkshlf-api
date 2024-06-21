package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Edition;
import com.example.bkshlf.model.Series;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class BookResource
{
    public static String wrapper = "book";
    public static String collectionWrapper = "books";

    private String id;
    private String title;
    private String description;
    private Integer series_order;
    private Set<Author> authors = new HashSet<>();
    private Set<Edition> editions = new HashSet<>();
    private Series series;
}
