package com.sofkau.apigateway.controllers.accounts.impl;

import com.sofkau.apigateway.clients.accounts.IAccountClient;
import com.sofkau.apigateway.controllers.accounts.IAccountsController;
import com.sofkau.apigateway.models.accounts.request.AccountRequestDTO;
import com.sofkau.apigateway.models.accounts.request.UpdateBalanceRequestDTO;
import com.sofkau.apigateway.models.accounts.response.AccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController implements IAccountsController {

    @Autowired
    private IAccountClient accountClient ;

    @PostMapping
    @Override
    public Mono<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountDTO, ServerHttpRequest originalRequest) {
        return accountClient.createAccount(accountDTO, originalRequest);
    }

    @Override
    @GetMapping("/{id}")
    public Mono<AccountResponseDTO> getAccount(@PathVariable Long id, ServerHttpRequest originalRequest) {
        return accountClient.getAccount(id, originalRequest);
    }

    @Override
    @PostMapping("/{id}/balance")
    public Mono<AccountResponseDTO> updateBalance(@PathVariable Long id, @RequestBody UpdateBalanceRequestDTO request, ServerHttpRequest originalRequest) {
        return accountClient.updateBalance(id, request, originalRequest);
    }

    @Override
    @GetMapping("/customer/{id}")
    public Flux<AccountResponseDTO> getAccountsByCustomerId(@PathVariable Long id, ServerHttpRequest originalRequest) {
        return accountClient.getAccountsByCustomerId(id, originalRequest);
    }
}
