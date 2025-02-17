package com.sofkau.apigateway.models.accounts.request;

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
public class UpdateBalanceRequestDTO implements Serializable {
    private BigDecimal newBalance;
}
