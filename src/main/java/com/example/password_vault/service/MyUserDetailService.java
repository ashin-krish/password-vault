package com.example.password_vault.service;


import com.example.password_vault.entity.AppUser;
import com.example.password_vault.entity.Credential;
import com.example.password_vault.repo.AppUserRepo;
import com.example.password_vault.repo.CredRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService
{

    final private AppUserRepo appUserRepo;


    public MyUserDetailService(AppUserRepo appUserRepo)
    {
        this.appUserRepo=appUserRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<AppUser> appUser = appUserRepo.findByUsername(username);

     if(credential.isEmpty())
     {
         throw new UsernameNotFoundException("No User Exists");
     }

        return User.withUsername(credential.get().getUsername())
                .password()
    }
}
