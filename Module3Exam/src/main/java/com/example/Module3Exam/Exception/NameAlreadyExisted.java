package com.example.Module3Exam.Exception;

public class NameAlreadyExisted extends RuntimeException {
    public NameAlreadyExisted(String message) {
        super(message);
    }
}
