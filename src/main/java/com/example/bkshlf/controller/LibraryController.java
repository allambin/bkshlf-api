package com.example.bkshlf.controller;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.response.BooksWrapper;
import com.example.bkshlf.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController
{
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService)
    {
        this.libraryService = libraryService;
    }

    @GetMapping
    public BooksWrapper showAll()
    {
        List<Book> books = libraryService.getAllBooks();
        return new BooksWrapper(books);
    }
}
