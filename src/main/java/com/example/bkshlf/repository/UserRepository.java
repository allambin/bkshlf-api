package com.example.bkshlf.repository;

import com.example.bkshlf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
