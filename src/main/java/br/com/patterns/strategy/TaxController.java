package br.com.patterns.strategy;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patterns")
@RequiredArgsConstructor
public class TaxController {

  private final TaxCalculatorService service;
  private final TaxCalculatorStrategyService serviceStrategy;

  @GetMapping("/without/strategy")
  public BigDecimal getTax(@RequestBody TaxRequest request){

    return service.calculate(request);
  }

  @GetMapping
  public BigDecimal getTaxStrategy(@RequestBody TaxRequest request){

    TaxTypeInterface taxType;

    if (request.taxType().equals("ISS"))
      taxType = new ISS();
    else if (request.taxType().equals("ICMS"))
      taxType = new ICMS();
    else if (request.taxType().equals("IPI"))
      taxType = new IPI();
    else
      throw new IllegalArgumentException("Invalid tax type");

    return serviceStrategy
        .setTexType(taxType)
        .calculate(request.amount());
  }

}
