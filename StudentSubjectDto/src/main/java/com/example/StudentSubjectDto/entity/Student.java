package com.example.StudentSubjectDto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int rollno;
    private String name;
    private String dept;
    private int age;

    public Student(int rollno, String name, String dept, int age) {
        this.rollno = rollno;
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    public Student(int i, String name) {
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }
}
