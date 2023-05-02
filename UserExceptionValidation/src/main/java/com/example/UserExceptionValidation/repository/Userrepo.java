package com.example.UserExceptionValidation.repository;

import com.example.UserExceptionValidation.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User,Integer> {
}
