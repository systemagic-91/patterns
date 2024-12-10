package br.com.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IPI implements TaxTypeInterface{

  @Override
  public BigDecimal calculate(BigDecimal amount) {

    return amount
        .multiply(new BigDecimal(15))
        .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
  }
}
