package com.agileactors.abstractfactory.service.geography;

import com.agileactors.abstractfactory.enums.MeansOfTransportationEnum;

public interface GeographyService {

  MeansOfTransportationEnum getMeansOfTransportation(String pointOfDeparture,
                                                     String destination);
}
