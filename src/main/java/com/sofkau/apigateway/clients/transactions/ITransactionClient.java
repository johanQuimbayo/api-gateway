package com.sofkau.apigateway.clients.transactions;

import com.sofkau.apigateway.models.transactions.request.TransactionRequestDTO;
import com.sofkau.apigateway.models.transactions.response.TransactionResponseDTO;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

public interface ITransactionClient {
    Mono<TransactionResponseDTO> performTransaction(TransactionRequestDTO transactionRequestDTO, ServerHttpRequest originalRequest);
    Mono<TransactionResponseDTO> streamTransactions(String accountId, ServerHttpRequest originalRequest);
}
