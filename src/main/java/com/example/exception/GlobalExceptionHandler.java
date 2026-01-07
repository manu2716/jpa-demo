package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<UserError> handleUserNotFoundException(UserNotFoundException ex){
            UserError userError = new UserError(HttpStatus.NOT_FOUND.value(),ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userError);
        }
}
