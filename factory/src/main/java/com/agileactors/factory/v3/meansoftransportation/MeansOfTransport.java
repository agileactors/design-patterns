package com.agileactors.factory.v3.meansoftransportation;

public interface MeansOfTransport {

  void checkCargo(String cargo);

  void loadCargo(Double quantity);

  void sendToDestination(String destination);
}
