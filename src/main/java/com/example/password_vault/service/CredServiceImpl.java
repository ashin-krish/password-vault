package com.example.password_vault.service;

import com.example.password_vault.entity.Credential;
import com.example.password_vault.exception.CredentialDoesNotFoundException;
import com.example.password_vault.repo.CredRepo;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialNotFoundException;
import java.security.cert.CertificateRevokedException;
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

        Optional<Credential> credential = credRepo.findById(id);

        if(credential.isEmpty())
        {
            throw new CredentialDoesNotFoundException(" Credential Does Not Exist ");
        }

        return credential;
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
            throw new CredentialDoesNotFoundException("No Credential Found");
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
     throw new CredentialDoesNotFoundException("No Credential Exist");
    }
}
