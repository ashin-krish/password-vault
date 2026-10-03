package com.example.password_vault.controller;

import com.example.password_vault.dto.LoginRequest;
import com.example.password_vault.entity.AppUser;
import com.example.password_vault.repo.AppUserRepo;
import com.example.password_vault.service.AppUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
     final private AuthenticationManager authenticationManager;
     final private AppUserService appUserService;

     SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

     AuthController(AuthenticationManager authenticationManager,AppUserService appUserService)
     {
         this.authenticationManager=authenticationManager;
         this.appUserService=appUserService;
     }

     @PostMapping("/login")
     public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response)
     {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

         SecurityContext context = SecurityContextHolder.createEmptyContext();

         context.setAuthentication(authentication);

         SecurityContextHolder.setContext(context);

         securityContextRepository.saveContext(context,request,response);

         return ResponseEntity.ok(" Login Successfull ");
     }

     @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody AppUser appUser)
     {
         appUserService.saveUser(appUser);

        return ResponseEntity.ok(" User Created ");
     }


}
