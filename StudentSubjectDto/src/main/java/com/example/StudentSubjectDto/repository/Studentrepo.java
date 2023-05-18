package com.example.StudentSubjectDto.repository;

import com.example.StudentSubjectDto.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student,Integer> {
}
