package com.sofkau.apigateway.controllers.transactions.impl;

import com.sofkau.apigateway.clients.transactions.ITransactionClient;
import com.sofkau.apigateway.controllers.transactions.ITransactionController;
import com.sofkau.apigateway.models.transactions.request.TransactionRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController implements ITransactionController {

    @Autowired
    private ITransactionClient transactionClient;

    @Override
    @PostMapping()
    public Mono<ServerResponse> performTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO, ServerHttpRequest originalRequest) {
        return transactionClient.performTransaction(transactionRequestDTO, originalRequest);
    }

    @Override
    @GetMapping("/stream")
    public Mono<ServerResponse> streamTransactions(@PathVariable("accountId") String accountId, ServerHttpRequest originalRequest) {
        return transactionClient.streamTransactions(accountId, originalRequest);
    }

}
