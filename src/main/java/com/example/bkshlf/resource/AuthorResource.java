package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorResource extends Resource<Author, AuthorResource>
{
    public static String resourceWrapper = "author";
    public static String collectionWrapper = "authors";

    private String id;
    private String name;
    private Set<BookResource> books;

    @Override
    public AuthorResource toArray(Author model)
    {
        this.setId(model.getId());
        this.setName(model.getName());
        this.setBooks(BookResource.toCollection(model.getBooks().forEach(BookResource::toArray))); // map toArray? // change to use non-static methods?
        return this;
    }
}
