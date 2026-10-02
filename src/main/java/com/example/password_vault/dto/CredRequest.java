package com.example.password_vault.dto;

import jakarta.validation.constraints.NotBlank;

public class CredRequest
{

    @NotBlank
    private String website;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
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
