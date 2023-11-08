package com.agileactors.factory.common.service.tax;

import java.math.BigDecimal;

public interface TaxService {

  BigDecimal applyTaxesOnCargo(String cargo, BigDecimal net);
}
