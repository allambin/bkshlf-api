package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AuthorResource extends JsonResource<Author>
{
    public AuthorResource()
    {
        super("author", "authors");
    }

    @Override
    public Map<String, Object> toArray(Author model)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("id", model.getId());
        map.put("name", model.getName());
        BookResource bookResource = new BookResource();
        List<Book> books = new ArrayList<>(model.getBooks());
        map.putAll(bookResource.toCollection(books));
        return map;
    }
}
