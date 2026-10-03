package com.example.password_vault.repo;

import com.example.password_vault.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long>
{
    AppUser findByUsername(String name);
}
