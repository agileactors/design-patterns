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
public class Truck {

  private static final Double MAX_CARGO_LOAD = 1200.00;
  private String licensePlate;

  public void checkCargo(String cargo) {
    log.info("Checking what is needed to load cargo of type {}", cargo);
  }

  public void loadCargo(Double quantity, BigDecimal price) {
    if (quantity.compareTo(MAX_CARGO_LOAD) > 0) {
      log.info("Loaded cargo with quantity {} and price {} into several trucks.", quantity, price);
    } else {
      log.info("Loaded cargo with quantity {} ad price {} into one truck.", quantity, price);
    }
  }

  public void sendToDestination(String destination) {
    log.info("Sending cargo to destination {}", destination);
  }
}
