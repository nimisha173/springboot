package com.example.CurdWithDto.dto;


import javax.validation.constraints.*;

public class UserReq {
    @NotNull(message="should not be null")
    @Size(min = 5,max = 10)
    private String name;
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String pno;
    @Min(20)
    @Max(60)
    private int age;
    @Email
    private String email;

    public UserReq(String name, String pno, int age, String email) {
        this.name = name;
        this.pno = pno;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
