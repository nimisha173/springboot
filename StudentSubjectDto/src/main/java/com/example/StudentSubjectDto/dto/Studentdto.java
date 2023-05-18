package com.example.StudentSubjectDto.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.rmi.MarshalException;

public class Studentdto {

    @NotNull(message="should not null")
    @Size(max = 20)
    private String name;
    @NotNull(message = "not null")
    private String dept;
    @Min(18)
    @Max(70)
    private int age;

    public Studentdto(String name, String dept, int age) {

        this.name = name;
        this.dept = dept;
        this.age = age;
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

    public Studentdto() {
    }
}
