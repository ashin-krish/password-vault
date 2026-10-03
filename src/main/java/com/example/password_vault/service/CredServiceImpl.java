package com.example.password_vault.service;

import com.example.password_vault.entity.Credential;
import com.example.password_vault.repo.CredRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        Optional<Credential> credential = credRepo.findById(id);

        if(credential.isPresent())
        {
            credRepo.deleteById(id);
        }
        else
        {
            throw new NoSuchElementException("No Credential Exists");
        }


    }

    @Override
    public Credential updateCredential(Credential credential,Long id)
    {
        Optional<Credential> existingCred = credRepo.findById(id);

     if(existingCred.isPresent())
     {
         existingCred.get().setPassword(credential.getPassword());
         existingCred.get().setUsername(credential.getUsername());

         return credRepo.save(existingCred.get());
     }
     throw new NoSuchElementException("No User Exist");
    }
}
