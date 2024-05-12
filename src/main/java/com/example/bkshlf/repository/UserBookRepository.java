package com.example.bkshlf.repository;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.UserBook;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long>
{
    @Transactional
    @Modifying
    @Query(
        value = "truncate table user_books",
        nativeQuery = true
    )
    void truncate();
}
