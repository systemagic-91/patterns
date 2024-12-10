package br.com.patterns.strategy;

import java.math.BigDecimal;

public interface TaxTypeInterface {

  BigDecimal calculate(BigDecimal amount);
}
