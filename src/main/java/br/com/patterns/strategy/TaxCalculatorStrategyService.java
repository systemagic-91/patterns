package br.com.patterns.strategy;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculatorStrategyService {

  private TaxTypeInterface taxType;

  public BigDecimal calculate(BigDecimal amount) {

    return this.taxType.calculate(amount);
  }

  public TaxCalculatorStrategyService setTexType(TaxTypeInterface taxType) {

    this.taxType = taxType;
    return this;
  }
}
