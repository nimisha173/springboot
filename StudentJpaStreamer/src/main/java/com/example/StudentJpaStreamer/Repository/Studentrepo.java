package com.example.StudentJpaStreamer.Repository;

import com.example.StudentJpaStreamer.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface Studentrepo extends JpaRepository<Student,Integer> {

}
