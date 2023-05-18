package com.example.ExamModel.repository;

import com.example.ExamModel.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MgRepo extends JpaRepository<Manager,Integer> {
}
