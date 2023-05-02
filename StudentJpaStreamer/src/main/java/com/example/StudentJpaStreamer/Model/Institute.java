package com.example.StudentJpaStreamer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Institute {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String location;
        @ElementCollection
        private List<String>coursesAvailable;

        @ElementCollection
        @MapKeyColumn(name = "course_name")
        @Column(name = "price")
        private HashMap<String, Integer> courses;

        @ManyToMany(mappedBy = "institutes")
        private List<Student> students;

        // Constructor, getters and setters
        // ...
    }


