package com.sofkau.apigateway.clients.transactions.impl;

import com.sofkau.apigateway.clients.transactions.ITransactionClient;
import com.sofkau.apigateway.models.transactions.request.TransactionRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class TransactionClient implements ITransactionClient {

    private final WebClient webClient;

    public TransactionClient(WebClient.Builder webClientBuilder, @Value("${transaction.service.url}") String accountServiceUrl) {
        this.webClient = webClientBuilder.baseUrl(accountServiceUrl).build();
    }


    @Override
    public Mono<ServerResponse> performTransaction(TransactionRequestDTO transactionRequestDTO, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return webClient.post()
                .uri("/api/transactions") // Ruta del servicio
                .header(HttpHeaders.AUTHORIZATION, token)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(transactionRequestDTO)
                .retrieve()
                .bodyToMono(ServerResponse.class)
                .onErrorResume(ex -> Mono.error(new RuntimeException("Error en la transacción: " + ex.getMessage())));
    }

    @Override
    public Mono<ServerResponse> streamTransactions(String accountId, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/transactions/stream")
                        .queryParam("accountId", accountId)
                        .build())
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(ServerResponse.class)
                .onErrorResume(ex -> Mono.error(new RuntimeException("Error al obtener transacciones: " + ex.getMessage())));
    }
}
