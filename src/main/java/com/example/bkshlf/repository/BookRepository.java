package com.example.bkshlf.repository;

import com.example.bkshlf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
