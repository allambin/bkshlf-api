package com.example.bkshlf.controller;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.resource.AuthorResource;
import com.example.bkshlf.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        AuthorResource authorResource = new AuthorResource();
        return ResponseEntity.ok().body(authorResource.toResource(author));
    }
}
