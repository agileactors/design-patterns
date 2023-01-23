package com.agileactors.factory.v1.meansoftransportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Slf4j
public class Truck {

  private static final Double MAX_CARGO_LOAD = 1200.00;
  private String licensePlate;

  public void checkCargo(String cargo) {
    log.info("Checking what is needed to load cargo of type {}", cargo);
  }

  public void loadCargo(Double quantity) {
    if (quantity.compareTo(MAX_CARGO_LOAD) > 0) {
      log.info("Loaded cargo with quantity {} into several trucks.", quantity);
    } else {
      log.info("Loaded cargo with quantity {} into one truck.", quantity);
    }
  }

  public void sendToDestination(String destination) {
    log.info("Sending cargo to destination {}", destination);
  }
}
