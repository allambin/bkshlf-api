package com.example.bkshlf.response;

import com.example.bkshlf.dto.AuthorWithBooksDTO;
import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;

import java.util.List;

public class AuthorWrapper
{
    private AuthorWithBooksDTO author;

    public AuthorWrapper(AuthorWithBooksDTO author)
    {
        this.author = author;
    }

    public AuthorWithBooksDTO getAuthor()
    {
        return author;
    }

    public void setAuthor(AuthorWithBooksDTO author)
    {
        this.author = author;
    }
}
