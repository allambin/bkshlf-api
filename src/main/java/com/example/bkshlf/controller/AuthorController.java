package com.example.bkshlf.controller;

import com.example.bkshlf.dto.AuthorWithBooksDTO;
import com.example.bkshlf.dto.BookDTO;
import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.resource.AuthorResource;
import com.example.bkshlf.resource.BookResource;
import com.example.bkshlf.resource.Resource;
import com.example.bkshlf.response.AuthorWrapper;
import com.example.bkshlf.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Object> show(@PathVariable("authorId") String authorId)
    {
        Author author = authorService.getAuthorWithBooks(authorId);
//        AuthorWithBooksDTO authorWithBooksDTO = mapAuthorToDTO(author);
        return ResponseEntity.ok().body(Resource.toResource(author, AuthorResource.class));

//        return new AuthorWrapper(authorWithBooksDTO);
    }

    private AuthorWithBooksDTO mapAuthorToDTO(Author author)
    {
        AuthorWithBooksDTO dto = new AuthorWithBooksDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBooks(mapBooksToDTO(author.getBooks()));

        return dto;
    }

    private Set<BookDTO> mapBooksToDTO(Set<Book> books)
    {
        Set<BookDTO> booksDTOs = new HashSet<>();
        for (Book book : books) {
            BookDTO dto = new BookDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            booksDTOs.add(dto);
        }

        return booksDTOs;
    }
}
