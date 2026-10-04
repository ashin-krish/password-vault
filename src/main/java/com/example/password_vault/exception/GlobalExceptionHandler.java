package com.example.password_vault.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandler
{
    ResponseEntity<String> handleCredentialDoesNotFoundException(CredentialDoesNotFoundException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    ResponseEntity<String> handleRequestUnsatisfiedException(RequestUnsatisfiedException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }


}
