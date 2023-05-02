package com.example.UserExceptionValidation.repository;

import com.example.UserExceptionValidation.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepo extends JpaRepository<User,Integer> {
    Optional<User> findByName(String name);
}
