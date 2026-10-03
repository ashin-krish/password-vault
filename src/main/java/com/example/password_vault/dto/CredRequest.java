package com.example.password_vault.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CredRequest
{

    @NotBlank
    @Size(max = 255)
    private String website;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(min = 8,max = 20)
    private String password;

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {

        this.website = website;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }



}
