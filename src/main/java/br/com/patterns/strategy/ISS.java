package br.com.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ISS implements TaxTypeInterface{

  @Override
  public BigDecimal calculate(BigDecimal amount) {

    return amount
        .multiply(new BigDecimal(11))
        .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
  }
}
