package com.sofkau.apigateway.clients.audit.impl;

import com.sofkau.apigateway.clients.audit.IAuditClient;
import com.sofkau.apigateway.models.audit.response.MessageDTO;
import com.sofkau.apigateway.models.audit.response.PageResponseDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;




@Service
public class AuditClient implements IAuditClient {

    private final WebClient webClient;

    public AuditClient(WebClient.Builder webClientBuilder, @Value("${audit.service.url}") String accountServiceUrl) {
        this.webClient = webClientBuilder.baseUrl(accountServiceUrl).build();
    }

    @Override
    public Mono<PageResponseDTO<MessageDTO>> getMessagesByIdEntidad(String idEntidad, Pageable pageable, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/messages/byIdEntidad/{idEntidad}")
                        .queryParam("page", pageable.getPageNumber())
                        .queryParam("size", pageable.getPageSize())
                        .build(idEntidad))
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<PageResponseDTO<MessageDTO>>() {})
                .onErrorResume(ex -> Mono.error(new RuntimeException("Error al obtener mensajes: " + ex.getMessage())));
    }

    @Override
    public Mono<PageResponseDTO<MessageDTO>> getMessagesByRecurso(String recurso, Pageable pageable, ServerHttpRequest originalRequest) {
        String token = originalRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/messages/byRecurso/{recurso}")
                        .queryParam("page", pageable.getPageNumber())
                        .queryParam("size", pageable.getPageSize())
                        .build(recurso))
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<PageResponseDTO<MessageDTO>>() {})
                .onErrorResume(ex -> Mono.error(new RuntimeException("Error al obtener mensajes por recurso: " + ex.getMessage())));
    }
}
