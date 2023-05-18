package com.example.StudentSubjectDto.repository;

import com.example.StudentSubjectDto.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Subjectrepo extends JpaRepository<Subject,Integer> {
}
