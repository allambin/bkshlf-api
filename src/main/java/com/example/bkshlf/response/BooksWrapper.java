package com.example.bkshlf.response;

import com.example.bkshlf.model.Book;

import java.util.List;

public class BooksWrapper
{
    private List<Book> books;

    public BooksWrapper(List<Book> books)
    {
        this.books = books;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
}
