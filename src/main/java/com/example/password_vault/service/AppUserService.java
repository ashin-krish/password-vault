package com.example.password_vault.service;


import com.example.password_vault.entity.AppUser;
import com.example.password_vault.repo.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService
{
   final private AppUserRepo appUserRepo;
   final private PasswordEncoder passwordEncoder;

   AppUserService(AppUserRepo appUserRepo,PasswordEncoder passwordEncoder)
   {
       this.appUserRepo=appUserRepo;
       this.passwordEncoder=passwordEncoder;
   }

    public void saveUser(AppUser appUser)
    {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        appUserRepo.save(appUser);
    }


}
