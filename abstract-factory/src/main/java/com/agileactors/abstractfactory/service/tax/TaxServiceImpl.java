package com.agileactors.abstractfactory.service.tax;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaxServiceImpl implements TaxService {

  @Override
  public BigDecimal applyTaxesOnCargo(String cargo, BigDecimal net) {
    if (cargo.startsWith("A")) {
      return net.add(net.multiply(BigDecimal.valueOf(0.13)));
    }
    return net.add(net.multiply(BigDecimal.valueOf(0.23)));
  }
}
