package com.agileactors.abstractfactory.factory.concrete;

import com.agileactors.abstractfactory.factory.abs.MeansOfTransportationOfEraFactory;
import com.agileactors.abstractfactory.meansoftransportation.airplane.Airplane;
import com.agileactors.abstractfactory.meansoftransportation.airplane.PostwarAirplane;
import com.agileactors.abstractfactory.meansoftransportation.ship.PostwarShip;
import com.agileactors.abstractfactory.meansoftransportation.ship.Ship;
import com.agileactors.abstractfactory.meansoftransportation.truck.PostwarTruck;
import com.agileactors.abstractfactory.meansoftransportation.truck.Truck;

public class PostwarFactory implements MeansOfTransportationOfEraFactory {
  @Override
  public Ship createShip() {
    return new PostwarShip();
  }

  @Override
  public Airplane createAirplane() {
    return new PostwarAirplane();
  }

  @Override
  public Truck createTruck() {
    return new PostwarTruck();
  }
}
