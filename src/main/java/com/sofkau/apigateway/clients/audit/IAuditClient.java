package com.sofkau.apigateway.clients.audit;

import com.sofkau.apigateway.models.audit.response.MessageDTO;
import com.sofkau.apigateway.models.audit.response.PageResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;



public interface IAuditClient {


    Mono<PageResponseDTO<MessageDTO>> getMessagesByRecurso(String recurso, Pageable pageable, ServerHttpRequest originalRequest);

    Mono<PageResponseDTO<MessageDTO>> getMessagesByIdEntidad(String idEntidad, Pageable pageable, ServerHttpRequest originalRequest);


}
