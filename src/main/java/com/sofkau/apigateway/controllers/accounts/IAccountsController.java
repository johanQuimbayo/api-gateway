package com.sofkau.apigateway.controllers.accounts;

import com.sofkau.apigateway.models.accounts.request.AccountRequestDTO;
import com.sofkau.apigateway.models.accounts.request.UpdateBalanceRequestDTO;
import com.sofkau.apigateway.models.accounts.response.AccountResponseDTO;

import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountsController {
    Mono<AccountResponseDTO> createAccount(AccountRequestDTO accountDTO, ServerHttpRequest originalRequest);

    Mono<AccountResponseDTO> getAccount(Long id, ServerHttpRequest originalRequest);
    Mono<AccountResponseDTO> updateBalance(Long id,UpdateBalanceRequestDTO request, ServerHttpRequest originalRequest);
    Flux<AccountResponseDTO> getAccountsByCustomerId(Long customerId, ServerHttpRequest originalRequest);
}
