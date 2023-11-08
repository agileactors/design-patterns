package com.agileactors.factory.v3.meansoftransportation;

import java.math.BigDecimal;

public interface MeansOfTransport {

  void checkCargo(String cargo);

  void loadCargo(Double quantity, BigDecimal price);

  void sendToDestination(String destination);
}
