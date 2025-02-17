package com.sofkau.apigateway.models.transactions.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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
public class TransactionRequestDTO implements Serializable {
    @NotBlank()
    private String accountId;

    @NotBlank()
    private String transactionType;

    @NotNull()
    @DecimalMin(value = "0.01", inclusive = true)
    private BigDecimal amount;

    @NotBlank()
    private String userId;
}
