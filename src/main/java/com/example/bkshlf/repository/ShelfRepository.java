package com.example.bkshlf.repository;

import com.example.bkshlf.model.Shelf;
import com.example.bkshlf.model.UserBook;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long>
{
    Optional<Shelf> findByShortname(String shortname);
    Optional<Shelf> findByIdAndUserId(Long id, Long userId);
}
