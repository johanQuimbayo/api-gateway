package com.sofkau.apigateway.clients.accounts.impl;

import com.sofkau.apigateway.clients.accounts.IAccountClient;
import com.sofkau.apigateway.clients.autentication.impl.AuthClient;
import com.sofkau.apigateway.exceptions.UnauthorizedException;
import com.sofkau.apigateway.models.accounts.request.AccountRequestDTO;
import com.sofkau.apigateway.models.accounts.request.UpdateBalanceRequestDTO;
import com.sofkau.apigateway.models.accounts.response.AccountResponseDTO;

import com.sofkau.apigateway.models.autentication.response.AuthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountClient implements IAccountClient {


    private final WebClient webClient;

    @Autowired
    private AuthClient authClient;

    public AccountClient(WebClient.Builder webClientBuilder, @Value("${account.service.url}") String accountServiceUrl) {
        this.webClient = webClientBuilder.baseUrl(accountServiceUrl).build();
    }

    @Override
    public Mono<AccountResponseDTO> createAccount(AccountRequestDTO accountDTO, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
         Mono<AuthResponseDTO> verify = authClient.verifyToken(token);
         return webClient.post()
                    .uri("/api/accounts")
                    .header(HttpHeaders.AUTHORIZATION, token)
                    .bodyValue(accountDTO)
                    .retrieve()
                    .bodyToMono(AccountResponseDTO.class);


    }

    @Override
    public Mono<AccountResponseDTO> getAccount(Long id, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        return webClient.get()
                .uri("/api/accounts/{id}", id)
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(AccountResponseDTO.class);
    }

    @Override
    public Mono<AccountResponseDTO> updateBalance(Long id, UpdateBalanceRequestDTO newBalance, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        return webClient.post()
                .uri("/api/accounts/{id}/balance", id)
                .header(HttpHeaders.AUTHORIZATION, token)
                .bodyValue(newBalance)
                .retrieve()
                .bodyToMono(AccountResponseDTO.class);
    }

    @Override
    public Flux<AccountResponseDTO> getAccountsByCustomerId(Long id, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return webClient.get()
                .uri("/api/accounts/customer/{id}", id)
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToFlux(AccountResponseDTO.class);
    }
}
