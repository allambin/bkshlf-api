package com.example.bkshlf.repository;

import com.example.bkshlf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, String>
{
    @Query("SELECT b FROM Book b JOIN b.editions e WHERE b.id = :bookId AND e.id = :editionId")
    Book findWithEdition(@Param("bookId") String bookId, @Param("editionId") long editionId);
}
