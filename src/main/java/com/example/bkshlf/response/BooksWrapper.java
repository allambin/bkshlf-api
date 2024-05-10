package com.example.bkshlf.response;

import com.example.bkshlf.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BooksWrapper
{
    private List<Book> books;

    public BooksWrapper(List<Book> books)
    {
        this.books = books;
    }

}
