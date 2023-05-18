package com.example.UserExceptionValidation.controller;

import com.example.UserExceptionValidation.Entity.User;
import com.example.UserExceptionValidation.Exception.UserNotFoundException;
import com.example.UserExceptionValidation.dto.UserRequest;
import com.example.UserExceptionValidation.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Usercontrolller {
    @Autowired
    private Userservice userservice;
    @PostMapping("/add")
    public ResponseEntity<User> adduser(@RequestBody @Valid UserRequest request){
       return new ResponseEntity<>(userservice.PostUser(request),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<User>> getuser() {

        return ResponseEntity.ok(userservice.getuser());
    }
    @GetMapping("/{id}")
    public User getid(@PathVariable Integer id)throws UserNotFoundException{
        return userservice.GetById(id).orElse(null);
    }
//    @PutMapping("/{id}")
//    public User update(@RequestBody User user){
//        return userservice.update(user).orElse(null);
//    }


}
