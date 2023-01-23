package com.agileactors.abstractfactory.meansoftransportation.ship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Slf4j
public class PostwarShip implements Ship {

  private static final Double MAX_CARGO_LOAD = 23000.00;
  private String name;

  public void checkCargo(String cargo) {
    log.info("Checking what is needed to load cargo of type {} into the postwar ship", cargo);
  }

  public void loadCargo(Double quantity) {
    if (quantity.compareTo(MAX_CARGO_LOAD) > 0) {
      log.info("Loaded cargo with quantity {} into several postwar ships to be transported.",
          quantity);
    } else {
      log.info("Loaded cargo with quantity {} into one postwar ship.", quantity);
    }
  }

  public void sendToDestination(String destination) {
    log.info("Sending cargo to port {}", destination);
  }
}
