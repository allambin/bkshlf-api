package com.example.bkshlf.service;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService
{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    public Author getAuthorWithBooks(String authorId)
    {
        return authorRepository.findIdWithBooks(authorId);
    }
}
