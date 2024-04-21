package com.example.bkshlf.service;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService
{
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }
}
