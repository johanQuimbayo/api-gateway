package com.sofkau.apigateway.models.autentication.response;


public record AuthResponseDTO(
        String token,
        String email,
        long userId,
        String userName,
        String documentNumber
) {
}
