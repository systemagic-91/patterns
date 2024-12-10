package br.com.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculatorService {

  public BigDecimal calculate(TaxRequest taxRequest) {

    if (taxRequest.taxType().equals("ICMS"))
      return taxRequest.amount()
          .multiply(new BigDecimal(4))
          .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);

    if (taxRequest.taxType().equals("ISS"))
      return taxRequest.amount()
          .multiply(new BigDecimal(11))
          .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);

    if (taxRequest.taxType().equals("IPI"))
      return taxRequest.amount()
          .multiply(new BigDecimal(15))
          .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);

    throw new IllegalArgumentException("Invalid tax type");
  }
}
