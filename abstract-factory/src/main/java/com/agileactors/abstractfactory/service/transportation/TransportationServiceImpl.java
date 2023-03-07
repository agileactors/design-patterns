package com.agileactors.abstractfactory.service.transportation;

import com.agileactors.abstractfactory.dto.TransportationDto;
import com.agileactors.abstractfactory.enums.MeansOfTransportationEnum;
import com.agileactors.abstractfactory.factory.Factory;
import com.agileactors.abstractfactory.factory.abs.MeansOfTransportationOfEraFactory;
import com.agileactors.abstractfactory.meansoftransportation.MeansOfTransport;
import com.agileactors.abstractfactory.service.geography.GeographyService;
import com.agileactors.abstractfactory.service.tax.TaxService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransportationServiceImpl implements TransportationService {

  private final TaxService taxService;
  private final GeographyService geographyService;

  @Override
  public String transportCargo(TransportationDto transportationDto, String era) {

    MeansOfTransportationOfEraFactory meansOfTransportationOfEraFactory =
        Factory.getFactoryOfEra(era);

    MeansOfTransportationEnum meansOfTransportEnum =
        geographyService.getMeansOfTransportation(transportationDto.pointOfDeparture(),
            transportationDto.destination());

    MeansOfTransport meansOfTransport =
        Factory.getMeansOfTransport(meansOfTransportEnum,
            meansOfTransportationOfEraFactory);

    log.info("Transporting cargo {} of quantity {} and net cost {} via {}...",
        transportationDto.cargo(), transportationDto.quantity(), transportationDto.cost(),
        meansOfTransportEnum);

    meansOfTransport.checkCargo(transportationDto.cargo());

    BigDecimal finalPrice =
        taxService.applyTaxesOnCargo(transportationDto.cargo(), transportationDto.cost());
    log.info("Final price after taxing is {} ", finalPrice);

    meansOfTransport.loadCargo(transportationDto.quantity());
    meansOfTransport.sendToDestination(transportationDto.destination());

    return "Cargo was transported successfully via " + meansOfTransportEnum;
  }

}
