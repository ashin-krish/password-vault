package com.example.password_vault.service;


import com.example.password_vault.entity.AppUser;
import com.example.password_vault.repo.AppUserRepo;
import org.springframework.stereotype.Service;

@Service
public class AppUserService
{
   final private AppUserRepo appUserRepo;

   AppUserService(AppUserRepo appUserRepo)
   {
       this.appUserRepo=appUserRepo;
   }

    public void saveUser(AppUser appUser)
    {
        appUserRepo.save(appUser);
    }


}
