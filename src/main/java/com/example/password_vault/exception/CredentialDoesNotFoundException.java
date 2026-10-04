package com.example.password_vault.exception;

public class CredentialDoesNotFoundException extends RuntimeException
{
    public CredentialDoesNotFoundException(String message)
    {
        super(message);
    }

}
