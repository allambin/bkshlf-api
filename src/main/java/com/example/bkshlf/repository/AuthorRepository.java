package com.example.bkshlf.repository;

import com.example.bkshlf.model.Author;
import com.example.bkshlf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String>
{
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id = ?1")
    Author findIdWithBooks(String id);
}
