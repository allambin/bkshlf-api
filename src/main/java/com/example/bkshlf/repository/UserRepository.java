package com.example.bkshlf.repository;

import com.example.bkshlf.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
        value = "truncate table users",
        nativeQuery = true
    )
    void truncate();
}
