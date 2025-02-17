package com.sofkau.apigateway.clients.autentication.impl;

import com.sofkau.apigateway.clients.autentication.IAuthClient;
import com.sofkau.apigateway.models.autentication.request.AuthRequestDTO;
import com.sofkau.apigateway.models.autentication.request.CustomerRequestDTO;
import com.sofkau.apigateway.models.autentication.request.VerifyTokenRequest;
import com.sofkau.apigateway.models.autentication.response.AuthResponseDTO;
import com.sofkau.apigateway.models.autentication.response.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthClient implements IAuthClient {

    private final WebClient webClient;

    public AuthClient(WebClient.Builder webClientBuilder, @Value("${auth.service.url}") String authServiceUrl) {
        this.webClient = webClientBuilder.baseUrl(authServiceUrl).build();
    }

    @Override
    public Mono<AuthResponseDTO> authenticate(AuthRequestDTO authRequestDTO) {
        return   webClient.post()
                .uri("/api/auth/login")
                .bodyValue(authRequestDTO)
                .retrieve()
                .bodyToMono(AuthResponseDTO.class);

    }

    @Override
    public Mono<CustomerResponseDTO> register(CustomerRequestDTO customerRequestDTO) {
        return webClient.post()
                .uri("/api/customers")
                .bodyValue(customerRequestDTO)
                .retrieve()
                .bodyToMono(CustomerResponseDTO.class);

    }

    @Override
    public Mono<AuthResponseDTO> verifyToken(String token) {
        return   webClient.post()
                .uri("/api/auth/verify")
                .bodyValue(new VerifyTokenRequest(token))
                .retrieve()
                .bodyToMono(AuthResponseDTO.class);

    }
}
