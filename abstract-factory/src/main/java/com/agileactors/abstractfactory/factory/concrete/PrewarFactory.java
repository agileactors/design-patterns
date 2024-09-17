package com.agileactors.abstractfactory.factory.concrete;

import com.agileactors.abstractfactory.factory.abs.MeansOfTransportationOfEraFactory;
import com.agileactors.abstractfactory.meansoftransportation.airplane.Airplane;
import com.agileactors.abstractfactory.meansoftransportation.airplane.PrewarAirplane;
import com.agileactors.abstractfactory.meansoftransportation.ship.PrewarShip;
import com.agileactors.abstractfactory.meansoftransportation.ship.Ship;
import com.agileactors.abstractfactory.meansoftransportation.truck.PrewarTruck;
import com.agileactors.abstractfactory.meansoftransportation.truck.Truck;

public class PrewarFactory implements MeansOfTransportationOfEraFactory {
  @Override
  public Ship createShip() {
    return new PrewarShip();
  }

  @Override
  public Airplane createAirplane() {
    return new PrewarAirplane();
  }

  @Override
  public Truck createTruck() {
    return new PrewarTruck();
  }
}
