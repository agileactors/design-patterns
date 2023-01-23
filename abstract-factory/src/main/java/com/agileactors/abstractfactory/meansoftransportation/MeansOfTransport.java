package com.agileactors.abstractfactory.meansoftransportation;

public interface MeansOfTransport {

  public void checkCargo(String cargo);

  public void loadCargo(Double quantity);

  public void sendToDestination(String destination);
}
