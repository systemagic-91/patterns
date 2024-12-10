package br.com.patterns.strategy;

import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record TaxRequest(
    String taxType,
    BigDecimal amount
) {

}
