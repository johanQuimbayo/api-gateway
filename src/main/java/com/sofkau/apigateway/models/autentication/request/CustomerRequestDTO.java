package com.sofkau.apigateway.models.autentication.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO implements Serializable {

    @NotBlank
    String name;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String documentNumber;

    @NotBlank
    @Size(min = 6)
    String password;
}
