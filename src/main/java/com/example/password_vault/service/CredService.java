package com.example.password_vault.service;

import com.example.password_vault.entity.Credential;

import java.util.List;
import java.util.Optional;

public interface CredService
{
    Credential addCredential(Credential credential);

    List<Credential> getAllCredential();

    Optional<Credential> getCredentialById(Long id);

    void deleteCredential(Long id);

}
