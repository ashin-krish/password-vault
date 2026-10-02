package com.example.password_vault.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credentials")
public class Credential
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String website;

    private String username;

    private String password;


}
