package com.example.bkshlf.repository;

import com.example.bkshlf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, String>
{
    @Query("SELECT b FROM Book b JOIN b.editions e WHERE b.id = :bookId AND e.id = :editionId")
    Book findWithEdition(@Param("bookId") String bookId, @Param("editionId") long editionId);

    Book findByTitle(@Param("title") String title);
}
