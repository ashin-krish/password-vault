package com.example.password_vault.controller;


import com.example.password_vault.entity.Credential;
import com.example.password_vault.service.CredService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cred")
public class CredController
{
   private final CredService credService;

  public CredController(CredService credService)
   {
       this.credService=credService;
   }


   @PostMapping("/save")
    public Credential addCredential(@RequestBody Credential credential)
   {
       return credService.addCredential(credential);
   }


    @GetMapping("/GetAll")
    public List<Credential>  getAllCredential()
    {
        return credService.getAllCredential();
    }

    @GetMapping("/getById/{id}")
    public Optional<Credential> getCredById(@PathVariable Long id)
    {
        return credService.getCredentialById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCred(@PathVariable long id)
    {
        credService.deleteCredential(id);
    }



}
