package com.example.password_vault.repo;

import com.example.password_vault.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredRepo extends JpaRepository<Credential,Long>
{

}
