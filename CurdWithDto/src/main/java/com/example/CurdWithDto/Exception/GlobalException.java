package com.example.CurdWithDto.Exception;

import com.example.CurdWithDto.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UserNotFountException.class)
    public ResponseEntity<ErrorMessage> handleStudentNotFoundException1(UserNotFountException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}

