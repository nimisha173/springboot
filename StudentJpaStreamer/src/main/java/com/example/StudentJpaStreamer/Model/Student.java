package com.example.StudentJpaStreamer.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String studentname;
    private String email;
    private String phoneno;
    private String address;
    private String qualification;
    private String experience;
    @ElementCollection
    private List <String> courses;}
