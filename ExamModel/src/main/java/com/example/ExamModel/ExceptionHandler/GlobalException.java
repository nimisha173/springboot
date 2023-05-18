package com.example.ExamModel.ExceptionHandler;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalException extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(value = EmployeeNotFound.class)
//    public ResponseEntity<ErrorMessage> handleEmployeeNotFoundException1(EmployeeNotFound ex) {
//        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
//    }


}
