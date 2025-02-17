package com.sofkau.apigateway.models.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {
    private String transactionId;
    private String accountId;
    private String transactionType;
    private BigDecimal initialBalance;
    private BigDecimal amount;
    private BigDecimal finalBalance;
    private String status;
    private String timestamp;
}
