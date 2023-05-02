package com.example.StudentJpaStreamer.Controller;


import com.example.StudentJpaStreamer.Model.Student;
import com.example.StudentJpaStreamer.Service.StudentService;
import com.example.StudentJpaStreamer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public Student addstudents(@RequestBody Student student) {
        return service.addstudents(student);
    }

    @GetMapping("/allstudent")
    public List<Student> getAllStudents() {
        return service.getStudents();
    }
    @GetMapping("/students/{course}")
    public String getStudentCountForCourses(@PathVariable String course) {

        return service.getStudentCountForCourses(course);

    }
    @GetMapping("/student/{address}")
    public List<Student>getStudents(@PathVariable String address){
        return service.getListByLocation(address);
    }
}
