package com.agileactors.abstractfactory.service.tax;

import java.math.BigDecimal;

public interface TaxService {

  public BigDecimal applyTaxesOnCargo(String cargo, BigDecimal net);
}
