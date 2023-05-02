package com.example.StudentJpaStreamer.Service;

import com.example.StudentJpaStreamer.Model.Student;
import com.example.StudentJpaStreamer.Model.Student$;
import com.example.StudentJpaStreamer.Repository.Studentrepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private Studentrepo repo;
    @Autowired
    private JPAStreamer jpaStreamer;


    public Student addstudents(Student student) {
        return repo.save(student);

    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public String getStudentCountForCourses(String course) {

        return "Count of "+course+"is"+jpaStreamer.stream(Student.class)
                .flatMap(student -> student.getCourses().stream())
                .filter(courses -> course.contains(courses))
                .distinct()
                .count();
    }

    public List<Student> getListByLocation(String location) {
        return repo.findAll().stream()
                .filter(student -> student.getAddress().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }
}


