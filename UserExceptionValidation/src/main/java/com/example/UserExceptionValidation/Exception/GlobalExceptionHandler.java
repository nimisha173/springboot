package com.example.UserExceptionValidation.Exception;


import com.example.UserExceptionValidation.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorMessage> handleStudentNotFoundException(MethodArgumentNotValidException ex,
//                                                                       WebRequest request) {
//        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
//        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
//    }


    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleStudentNotFoundException1(UserNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(value = NameFoundException.class)
    public ResponseEntity<ErrorMessage> handleStudentNotFoundException2(NameFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

}