package com.example.UserExceptionValidation.service;

import com.example.UserExceptionValidation.Entity.User;
import com.example.UserExceptionValidation.Exception.UserNotFoundException;
import com.example.UserExceptionValidation.dto.UserRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {

    public User PostUser(User user) {
        return null;
    }

    public List<User> getuser() {
        return null;
    }

    public Optional<User> GetById(Integer id) throws UserNotFoundException {
        return null;
    }

}