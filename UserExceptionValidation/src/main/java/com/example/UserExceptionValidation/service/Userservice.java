package com.example.UserExceptionValidation.service;

import com.example.UserExceptionValidation.Entity.User;
import com.example.UserExceptionValidation.Exception.NameFoundException;
import com.example.UserExceptionValidation.Exception.UserNotFoundException;
import com.example.UserExceptionValidation.dto.UserRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Userservice {


    User PostUser(UserRequest userRequest) throws NameFoundException;

//    public User PostUser(User user);

    public List<User> getuser();

    public Optional<User> GetById(Integer id) throws UserNotFoundException;

}