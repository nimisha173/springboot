package com.example.Module3Exam.repository;

import com.example.Module3Exam.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Bookrepo extends JpaRepository<Book,Integer> {

    Optional<Book> findByBname(String bname);
}
