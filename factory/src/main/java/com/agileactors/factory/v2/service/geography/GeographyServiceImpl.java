package com.agileactors.factory.v2.service.geography;

import com.agileactors.factory.common.enums.MeansOfTransportationEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeographyServiceImpl implements GeographyService {

  @Override
  public MeansOfTransportationEnum getMeansOfTransportation(String pointOfDeparture,
                                                            String destination) {
    if (pointOfDeparture.compareTo(destination) > 0) {
      return MeansOfTransportationEnum.BOAT;
    } else if (pointOfDeparture.length() > 10) {
      return MeansOfTransportationEnum.AIRPLANE;
    } else {
      return MeansOfTransportationEnum.TRUCK;
    }
  }
}