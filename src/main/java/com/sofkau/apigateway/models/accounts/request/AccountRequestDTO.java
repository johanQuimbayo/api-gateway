package com.sofkau.apigateway.models.accounts.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO implements Serializable {

    @NotNull
    private String type;

    @NotNull
    private Long customerId;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private Long accountNumber;
}
