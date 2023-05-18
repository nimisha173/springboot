package com.example.Module3Exam.Exception;

import com.example.Module3Exam.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class GobalexceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UserNotFountException.class)
    public ResponseEntity<ErrorMessage> handleStudentNotFoundException1(UserNotFountException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(value = NameAlreadyExisted.class)
    public ResponseEntity<ErrorMessage> handleStudentNotFoundException1(NameAlreadyExisted ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);


    }
}
