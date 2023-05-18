package com.example.ExamModel.repository;

import com.example.ExamModel.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByName(String name);
}
