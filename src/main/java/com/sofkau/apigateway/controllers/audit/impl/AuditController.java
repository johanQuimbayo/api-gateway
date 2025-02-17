package com.sofkau.apigateway.controllers.audit.impl;

import com.sofkau.apigateway.clients.audit.IAuditClient;
import com.sofkau.apigateway.controllers.audit.IAuditController;
import com.sofkau.apigateway.models.audit.response.MessageDTO;
import com.sofkau.apigateway.models.audit.response.PageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;


@AllArgsConstructor
@RestController
@RequestMapping("/messages")
public class AuditController implements IAuditController {

    @Autowired
    private IAuditClient auditClient;

    @GetMapping("/byIdEntidad/{idEntidad}")
    public Mono<PageResponseDTO<MessageDTO>> getMessagesByIdEntidad(@PathVariable String idEntidad, @RequestParam Pageable pageable, ServerHttpRequest originalRequest) {
        return auditClient.getMessagesByIdEntidad(idEntidad, pageable, originalRequest);
    }

    @GetMapping("/byRecurso/{recurso}")
    public Mono<PageResponseDTO<MessageDTO>> getMessagesByRecurso(@PathVariable String recurso, @RequestParam Pageable pageable, ServerHttpRequest originalRequest) {
        return auditClient.getMessagesByRecurso(recurso, pageable, originalRequest );
    }

}
