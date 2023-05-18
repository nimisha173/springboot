package com.example.CurdWithDto.repository;

import com.example.CurdWithDto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByName(String name);
}
