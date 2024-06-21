package com.example.bkshlf.service;

import com.example.bkshlf.config.RestException;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.repository.BookRepository;
import com.example.bkshlf.resource.BookResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book getBookWithEdition(String bookId, long editionId)
    {
        return bookRepository.findWithEdition(bookId, editionId);
    }

    public Book getBook(String id) throws RestException
    {
        return bookRepository.findById(id).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found"));
    }

    protected BookResource toNakedResource(Book book)
    {
        BookResource resource = new BookResource();
        resource.setId(book.getId());
        resource.setTitle(book.getTitle());
        resource.setSeries(book.getSeries());

        return resource;
    }

    public Map<String, Object> toResource(Book book)
    {
        BookResource resource = toNakedResource(book);

        Map<String, Object> response = new HashMap<>();
        response.put(BookResource.wrapper, resource);

        return response;
    }

    public Map<String, List<BookResource>> toCollection(List<Book> books)
    {
        List<BookResource> collection = books.stream().map(this::toNakedResource).toList();
        return Collections.singletonMap(BookResource.collectionWrapper, collection);
    }
}
