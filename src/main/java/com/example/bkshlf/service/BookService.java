package com.example.bkshlf.service;

import com.example.bkshlf.config.RestException;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepository;

    public Book getBook(String id) throws RestException
    {
        return bookRepository.findById(id).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found"));
    }
}
