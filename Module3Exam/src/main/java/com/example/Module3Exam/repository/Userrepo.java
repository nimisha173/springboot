package com.example.Module3Exam.repository;

import com.example.Module3Exam.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {


    Optional<User> findByUname(String uname);
}
