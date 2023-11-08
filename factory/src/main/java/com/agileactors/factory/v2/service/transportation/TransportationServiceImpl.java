package com.agileactors.factory.v2.service.transportation;

import com.agileactors.factory.common.dto.TransportationDto;
import com.agileactors.factory.common.enums.MeansOfTransportationEnum;
import com.agileactors.factory.common.service.geography.GeographyService;
import com.agileactors.factory.common.service.tax.TaxService;
import com.agileactors.factory.v2.meansoftransportation.Airplane;
import com.agileactors.factory.v2.meansoftransportation.Ship;
import com.agileactors.factory.v2.meansoftransportation.Truck;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("TransportationServiceImplV2")
@RequiredArgsConstructor
@Slf4j
public class TransportationServiceImpl implements TransportationService {

  private final TaxService taxService;
  private final GeographyService geographyService;

  @Override
  public String transportCargo(TransportationDto transportationDto) {

    MeansOfTransportationEnum meansOfTransportationEnum =
        geographyService.getMeansOfTransportation(transportationDto.pointOfDeparture(),
            transportationDto.destination());
    log.info("Transporting cargo {} of quantity {} and net cost {} via {}...",
        transportationDto.cargo(), transportationDto.quantity(), transportationDto.cost(),
        meansOfTransportationEnum);

    Airplane airplane = new Airplane();
    Ship ship = new Ship();
    Truck truck = new Truck();

    if (MeansOfTransportationEnum.AIRPLANE.equals(meansOfTransportationEnum)) {
      airplane.checkCargo(transportationDto.cargo());
    } else if (MeansOfTransportationEnum.SHIP.equals(meansOfTransportationEnum)) {
      ship.checkCargo(transportationDto.cargo());
    } else {
      truck.checkCargo(transportationDto.cargo());
    }

    BigDecimal priceAfterTaxes =
        taxService.applyTaxesOnCargo(transportationDto.cargo(), transportationDto.cost());
    log.info("Final price after taxing is {} ", priceAfterTaxes);

    if (MeansOfTransportationEnum.AIRPLANE.equals(meansOfTransportationEnum)) {
      airplane.loadCargo(transportationDto.quantity(), priceAfterTaxes);
      airplane.sendToDestination(transportationDto.destination());
    } else if (MeansOfTransportationEnum.SHIP.equals(meansOfTransportationEnum)) {
      ship.loadCargo(transportationDto.quantity(), priceAfterTaxes);
      ship.sendToDestination(transportationDto.destination());
    } else {
      truck.loadCargo(transportationDto.quantity(), priceAfterTaxes);
      truck.sendToDestination(transportationDto.destination());
    }

    return "Cargo was transported successfully via " + meansOfTransportationEnum;
  }
}
