package com.example.Module3Exam.controller;

import com.example.Module3Exam.Entity.Book;
import com.example.Module3Exam.Entity.User;
import com.example.Module3Exam.Exception.NameAlreadyExisted;
import com.example.Module3Exam.Exception.UserNotFountException;
import com.example.Module3Exam.repository.Bookrepo;
import com.example.Module3Exam.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userbook")
public class Ubcontroller {
    @Autowired
    private Bookrepo brepo;
    @Autowired
    private Userrepo urepo;

    @PostMapping("/postbook")
    public ResponseEntity<Book> postbook(@RequestBody Book book) throws NameAlreadyExisted {
        Optional<Book> op6 = brepo.findByBname(book.getBname());
        if (op6.isPresent()) {
            throw new NameAlreadyExisted("name already exist");
        } else {
            brepo.save(book);
            return ResponseEntity.ok().body(book);
        }
    }

    @PostMapping("/postuser")
    public ResponseEntity<User> postuser(@RequestBody User user) throws NameAlreadyExisted {
        Optional<User> op5 = urepo.findByUname(user.getUname());
        if (op5.isPresent()) {
            throw new NameAlreadyExisted("name alredy exist");
        }
        urepo.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Optional<Book> b = brepo.findById(id);
        if (b.isPresent()) {
            return ResponseEntity.ok().body(b.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) throws UserNotFountException {
        Optional<User> op = urepo.findById(id);
        if (op.isPresent()) {

            return ResponseEntity.ok().body(op.get());
        } else {
           // return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//            Optional<User> op4 = urepo.findById(id);
//            if (op4.isPresent()) {
//                return ResponseEntity.ok().body(op4.get());
//            } else {
                throw new UserNotFountException("user is not found");
//            }
        }
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String> deluser(@PathVariable Integer id) {
        Optional<User> op = urepo.findById(id);
        if (op.isPresent()) {
            urepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body("deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<String> deleteb(@PathVariable Integer id) {
        Optional<Book> op2 = brepo.findById(id);
        if (op2.isPresent()) {
            brepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body("deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }

    @PutMapping("/a/up/{id}")
    public ResponseEntity<User> update(@RequestBody User u) {
        User user;
        Optional<User> op1 = urepo.findById(u.getId());
        if (op1.isPresent()) {
            user = op1.get();
            user.setId(u.getId());
            user.setUname(u.getUname());
            urepo.save(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @PutMapping("/updatebook/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book b) {
        Optional<Book> op3 = brepo.findById(b.getId());
        Book book;
        if (op3.isPresent()) {
            book = op3.get();
            book.setId(b.getId());
            book.setBname(b.getBname());
            brepo.save(book);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


    }
}