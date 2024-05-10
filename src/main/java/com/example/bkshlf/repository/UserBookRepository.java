package com.example.bkshlf.repository;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook, Long>
{

}
