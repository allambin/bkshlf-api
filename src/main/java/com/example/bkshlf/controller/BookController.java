package com.example.bkshlf.controller;

import com.example.bkshlf.config.RestException;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.resource.BookResource;
import com.example.bkshlf.resource.Resource;
import com.example.bkshlf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Object> showAll()
    {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(Resource.toCollection(books, BookResource.class));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Object> show(@PathVariable("bookId") String bookId) throws RestException
    {
        Book book = bookService.getBook(bookId);
        return ResponseEntity.ok().body(BookResource.toResource(book, BookResource.class));
    }
}
