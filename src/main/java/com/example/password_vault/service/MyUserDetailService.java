package com.example.password_vault.service;

import com.example.password_vault.entity.AppUser;
import com.example.password_vault.repo.AppUserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    final private AppUserRepo appUserRepo;


    public MyUserDetailService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserRepo.findByUsername(username);

        if (appUser.isEmpty()) {
            throw new UsernameNotFoundException(" No User Found Exception");
        }

        return User.withUsername(appUser.get().getUsername())
                .password(appUser.get().getPassword())
                .roles(appUser.get().getPassword())
                .build();

    }
}
