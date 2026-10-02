package com.example.password_vault.service;

import com.example.password_vault.entity.Credential;
import com.example.password_vault.repo.CredRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CredServiceImpl implements CredService
{
    private final CredRepo credRepo;

   public CredServiceImpl(CredRepo credRepo)
    {
        this.credRepo=credRepo;
    }


    @Override
    public Credential addCredential(Credential credential)
    {
       return credRepo.save(credential);
    }

    @Override
    public List<Credential> getAllCredential() {
       
        return credRepo.findAll();
    }

    @Override
    public Optional<Credential> getCredentialById(Long id) {

        return credRepo.findById(id);
    }

    @Override
    public void deleteCredential(Long id)
    {
        credRepo.deleteById(id);
    }
}
