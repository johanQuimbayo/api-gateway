package com.sofkau.apigateway.clients.transactions;

import com.sofkau.apigateway.models.transactions.request.TransactionRequestDTO;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ITransactionClient {
    Mono<ServerResponse> performTransaction(TransactionRequestDTO transactionRequestDTO, ServerHttpRequest originalRequest);
    Mono<ServerResponse> streamTransactions(String accountId, ServerHttpRequest originalRequest);
}
