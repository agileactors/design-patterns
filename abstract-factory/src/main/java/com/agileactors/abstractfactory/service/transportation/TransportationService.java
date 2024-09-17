package com.agileactors.abstractfactory.service.transportation;

import com.agileactors.abstractfactory.dto.TransportationDto;

public interface TransportationService {

  String transportCargo(TransportationDto transportationDto, String era);
}
