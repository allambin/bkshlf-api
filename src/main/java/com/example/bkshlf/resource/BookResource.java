package com.example.bkshlf.resource;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResource extends JsonResource<Book>
{
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
        if (Objects.equals(this.route, "books.show")) {
            AuthorResource authorResource = new AuthorResource();
            List<Author> authors = new ArrayList<>(model.getAuthors());
            map.putAll(authorResource.toCollection(authors));
            map.put("description", model.getDescription());
            map.put("series_order", model.getSeriesOrder());
            map.put("series", model.getSeries());
            map.put("editions", model.getEditions());
        }
        return map;
    }
}
