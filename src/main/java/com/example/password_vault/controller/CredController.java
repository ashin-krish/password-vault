package com.example.password_vault.controller;


import com.example.password_vault.dto.CredRequest;
import com.example.password_vault.dto.CredResponse;
import com.example.password_vault.entity.Credential;
import com.example.password_vault.service.CredService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cred")
public class CredController {
    private final CredService credService;

    public CredController(CredService credService) {
        this.credService = credService;
    }


    @PostMapping("/save")
    public CredResponse addCredential(@Valid @RequestBody CredRequest request) {

        Credential convertedCred = new Credential();

        convertedCred.setUsername(request.getUsername());
        convertedCred.setPassword(request.getPassword());
        convertedCred.setWebsite(request.getWebsite());

        Credential savedCred = credService.addCredential(convertedCred);

        CredResponse credResponse = new CredResponse();

        credResponse.setId(savedCred.getId());
        credResponse.setUsername(savedCred.getUsername());
        credResponse.setWebsite(savedCred.getWebsite());

        return credResponse;
    }


    @GetMapping("/GetAll")
    public List<CredResponse> getAllCredential() {

        List<Credential> credentials = credService.getAllCredential();

        List<CredResponse> responses = new ArrayList<>();

        for (Credential credential : credentials) {
            CredResponse response = new CredResponse();

            response.setUsername(credential.getUsername());
            response.setWebsite(credential.getWebsite());
            response.setId(credential.getId());

            responses.add(response);
        }

        return responses;

    }

    @GetMapping("/getById/{id}")
    public CredResponse getCredById(@PathVariable Long id) {

        Optional<Credential> credential = credService.getCredentialById(id);

        CredResponse response = new CredResponse();

        response.setId(credential.get().getId());
        response.setWebsite(credential.get().getWebsite());
        response.setUsername(credential.get().getUsername());


        return response;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteCred(@PathVariable long id) {

        credService.deleteCredential(id);
    }

    @PutMapping("/update/{id}")
    public CredResponse updateCred(@Valid @RequestBody CredRequest request, @PathVariable Long id) {
        Credential convertedCred = new Credential();

        convertedCred.setUsername(request.getUsername());
        convertedCred.setPassword(request.getPassword());

       Credential savedCred = credService.updateCredential(convertedCred, id);

        CredResponse credResponse = new CredResponse();

        credResponse.setUsername(savedCred.getUsername());
        credResponse.setWebsite(savedCred.getWebsite());
        credResponse.setId(savedCred.getId());

        return credResponse;


    }


}
