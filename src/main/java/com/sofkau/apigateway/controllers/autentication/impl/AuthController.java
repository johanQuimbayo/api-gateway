package com.sofkau.apigateway.controllers.autentication.impl;

import com.sofkau.apigateway.clients.autentication.IAuthClient;
import com.sofkau.apigateway.controllers.autentication.IAuthController;
import com.sofkau.apigateway.models.autentication.request.AuthRequestDTO;
import com.sofkau.apigateway.models.autentication.request.CustomerRequestDTO;
import com.sofkau.apigateway.models.autentication.response.AuthResponseDTO;
import com.sofkau.apigateway.models.autentication.response.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController implements IAuthController {

    @Autowired
    private IAuthClient authClient;

    @Override
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO authRequestDTO) {
        return authClient.authenticate(authRequestDTO);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerResponseDTO> register(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return authClient.register(customerRequestDTO);
    }
}
