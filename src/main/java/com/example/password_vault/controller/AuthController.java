package com.example.password_vault.controller;

import com.example.password_vault.dto.LoginRequest;
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

     SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

     AuthController(AuthenticationManager authenticationManager)
     {
         this.authenticationManager=authenticationManager;
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


}
