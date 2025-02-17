package com.sofkau.apigateway.controllers.audit;

import com.sofkau.apigateway.models.audit.response.MessageDTO;
import com.sofkau.apigateway.models.audit.response.PageResponseDTO;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;


public interface IAuditController {
    Mono<PageResponseDTO<MessageDTO>> getMessagesByIdEntidad(
            String idEntidad,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            ServerHttpRequest originalRequest);

    Mono<PageResponseDTO<MessageDTO>> getMessagesByRecurso(
            String recurso,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            ServerHttpRequest originalRequest);
}

