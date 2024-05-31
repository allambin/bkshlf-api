package com.example.bkshlf.controller;

import com.example.bkshlf.config.RestException;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{bookId}")
    public Book show(@PathVariable("bookId") String bookId) throws RestException
    {
        Book book = bookService.getBook(bookId);
        return book;
    }
}
