package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Edition;
import com.example.bkshlf.model.Series;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResource extends Resource<Book>
{
    @JsonIgnore
    public String resourceWrapper = "book";

    @JsonIgnore
    public String collectionWrapper = "books";

    public BookResource()
    {
        super("book", "books");
    }

    @Override
    public Map<String, Object> toArray(Book model)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("id", model.getId());
        map.put("title", model.getTitle());
        return map;
    }
}
