package com.example.StudentSubjectDto.ExceptionHandling;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
