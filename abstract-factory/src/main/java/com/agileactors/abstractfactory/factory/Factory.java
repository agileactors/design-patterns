package com.agileactors.abstractfactory.factory;

import com.agileactors.abstractfactory.enums.MeansOfTransportationEnum;
import com.agileactors.abstractfactory.factory.abs.MeansOfTransportationOfEraFactory;
import com.agileactors.abstractfactory.factory.concrete.PostwarFactory;
import com.agileactors.abstractfactory.factory.concrete.PrewarFactory;
import com.agileactors.abstractfactory.meansoftransportation.MeansOfTransport;

public class Factory {

  private Factory() {
  }

  public static MeansOfTransport getMeansOfTransport(
      MeansOfTransportationEnum meansOfTransportationEnum,
      MeansOfTransportationOfEraFactory factory) {

    return switch (meansOfTransportationEnum) {
      case AIRPLANE -> factory.createAirplane();
      case SHIP -> factory.createShip();
      default -> factory.createTruck();
    };
  }

  public static MeansOfTransportationOfEraFactory getFactoryOfEra(String era) {
    if ("prewar".equals(era)) {
      return new PrewarFactory();
    }
    return new PostwarFactory();
  }
}

