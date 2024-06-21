package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Edition;
import com.example.bkshlf.model.Series;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class BookResource extends Resource<Book, BookResource>
{
    public static String resourceWrapper = "book";
    public static String collectionWrapper = "books";

    private String id;
    private String title;
    private String description;
    private Integer series_order;
    private Set<Author> authors = new HashSet<>();
    private Set<Edition> editions = new HashSet<>();
    private Series series;

    @Override
    public BookResource toArray(Book model)
    {
        this.setId(model.getId());
        this.setTitle(model.getTitle());
        this.setSeries(model.getSeries());
        return this;
    }
}
