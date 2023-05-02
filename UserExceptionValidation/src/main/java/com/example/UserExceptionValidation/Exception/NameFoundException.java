package com.example.UserExceptionValidation.Exception;

public class NameFoundException extends RuntimeException{
    public NameFoundException(String msg) {
        super(msg);
    }
}
