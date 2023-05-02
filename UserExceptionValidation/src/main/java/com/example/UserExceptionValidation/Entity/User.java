package com.example.UserExceptionValidation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String pno;
    private int age;


}
