package com.sofkau.apigateway.controllers.transactions;

import com.sofkau.apigateway.models.transactions.request.TransactionRequestDTO;
import com.sofkau.apigateway.models.transactions.response.TransactionResponseDTO;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

;


public interface ITransactionController {
    Mono<TransactionResponseDTO> performTransaction(TransactionRequestDTO transactionRequestDTO, ServerHttpRequest originalRequest);
    Mono<TransactionResponseDTO> streamTransactions(String accountId, ServerHttpRequest originalRequest);
}
