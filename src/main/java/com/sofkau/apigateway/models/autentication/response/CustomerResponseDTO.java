package com.sofkau.apigateway.models.autentication.response;

public record CustomerResponseDTO (
        long id,
        String name,
        String email,
        String documentNumber,
        String password
) {
}
