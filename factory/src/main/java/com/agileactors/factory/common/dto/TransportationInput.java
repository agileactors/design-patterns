package com.agileactors.factory.common.dto;

import java.math.BigDecimal;

public record TransportationInput(String cargo, Double quantity, BigDecimal cost,
                                  String pointOfDeparture, String destination) {

}
