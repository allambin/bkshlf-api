package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class AuthorResource extends Resource<Author>
{
    public static String resourceWrapper = "author";
    public static String collectionWrapper = "authors";

    private String id;
    private String name;
    private Set<BookResource> books;

    @Override
    public Map<String, Object> toArray(Author model)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("id", model.getId());
        map.put("name", model.getName());
        //this.setBooks(BookResource.toCollection(model.getBooks().forEach(BookResource::toArray))); // map toArray? // change to use non-static methods?
        return map;
    }
}
