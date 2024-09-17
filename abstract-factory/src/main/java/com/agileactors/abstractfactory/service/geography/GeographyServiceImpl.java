package com.agileactors.abstractfactory.service.geography;

import com.agileactors.abstractfactory.enums.MeansOfTransportationEnum;
import org.springframework.stereotype.Service;

@Service
public class GeographyServiceImpl implements GeographyService {

  @Override
  public MeansOfTransportationEnum getMeansOfTransportation(String pointOfDeparture,
                                                            String destination) {
    if (pointOfDeparture.compareTo(destination) > 0) {
      return MeansOfTransportationEnum.SHIP;
    } else if (pointOfDeparture.length() > 10) {
      return MeansOfTransportationEnum.AIRPLANE;
    } else {
      return MeansOfTransportationEnum.TRUCK;
    }
  }
}
