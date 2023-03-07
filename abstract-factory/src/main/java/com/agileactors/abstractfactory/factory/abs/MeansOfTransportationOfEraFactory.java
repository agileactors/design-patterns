package com.agileactors.abstractfactory.factory.abs;

import com.agileactors.abstractfactory.meansoftransportation.airplane.Airplane;
import com.agileactors.abstractfactory.meansoftransportation.ship.Ship;
import com.agileactors.abstractfactory.meansoftransportation.truck.Truck;

public interface MeansOfTransportationOfEraFactory {
  Ship createShip();

  Airplane createAirplane();

  Truck createTruck();
}
