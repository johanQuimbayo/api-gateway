package com.sofkau.apigateway.controllers.autentication;

import com.sofkau.apigateway.models.autentication.request.AuthRequestDTO;
import com.sofkau.apigateway.models.autentication.request.CustomerRequestDTO;
import com.sofkau.apigateway.models.autentication.response.AuthResponseDTO;
import com.sofkau.apigateway.models.autentication.response.CustomerResponseDTO;
import reactor.core.publisher.Mono;

public interface IAuthController {

    Mono<AuthResponseDTO> authenticate(AuthRequestDTO authRequestDTO);
    Mono<CustomerResponseDTO> register(CustomerRequestDTO customerRequestDTO);
}
