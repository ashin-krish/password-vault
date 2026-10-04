package com.example.password_vault.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(CredentialDoesNotFoundException.class)
    ResponseEntity<String> handleCredentialDoesNotFoundException(CredentialDoesNotFoundException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(RequestUnsatisfiedException.class)
    ResponseEntity<String> handleRequestUnsatisfiedException(RequestUnsatisfiedException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(
            MethodArgumentNotValidException exception) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid request");
    }


}

