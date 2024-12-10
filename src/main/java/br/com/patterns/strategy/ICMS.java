package br.com.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ICMS implements TaxTypeInterface{

  @Override
  public BigDecimal calculate(BigDecimal amount) {

    return amount
        .multiply(new BigDecimal(4))
        .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
  }
}
