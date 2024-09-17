package com.agileactors.abstractfactory.dto;

import java.math.BigDecimal;

public record TransportationDto(String cargo, Double quantity, BigDecimal cost,
                                String pointOfDeparture, String destination) {

}
