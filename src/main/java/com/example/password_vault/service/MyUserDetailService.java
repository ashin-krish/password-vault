/*
package com.example.password_vault.service;


import com.example.password_vault.entity.Credential;
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

    final private CredRepo credRepo;


    public MyUserDetailService(CredRepo credRepo)
    {
        this.credRepo=credRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional <Credential> credential = credRepo.findByUsername(username);

     if(credential.isEmpty())
     {
         throw new UsernameNotFoundException("No User Exists");
     }

        return User.withUsername(credential.get().getUsername())
                .password()
    }
}
*/
