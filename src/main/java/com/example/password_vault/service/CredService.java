package com.example.password_vault.service;

import com.example.password_vault.entity.Credential;

import java.util.List;

public interface CredService
{
    Credential addCredential(Credential credential);

    List<CredService> getAllCredential();

    Credential getCredentialById(Long id);

    void deleteCredential(Long id);

}
