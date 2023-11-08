package com.agileactors.factory.v2.meansoftransportation;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Slf4j
public class Ship {

  private static final Double MAX_CARGO_LOAD = 13000.00;
  private String name;

  public void checkCargo(String cargo) {
    log.info("Checking what is needed to load cargo of type {} into the ship", cargo);
  }

  public void loadCargo(Double quantity, BigDecimal price) {
    if (quantity.compareTo(MAX_CARGO_LOAD) > 0) {
      log.info("Loaded cargo with quantity {} and price {} into several ships to be transported.", quantity, price);
    } else {
      log.info("Loaded cargo with quantity {} and price {} into one ship.", quantity, price);
    }
  }

  public void sendToDestination(String destination) {
    log.info("Sending cargo to port {}", destination);
  }
}
