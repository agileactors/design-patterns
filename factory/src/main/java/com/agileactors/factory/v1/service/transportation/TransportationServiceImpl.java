package com.agileactors.factory.v1.service.transportation;

import com.agileactors.factory.common.dto.TransportationDto;
import com.agileactors.factory.common.service.tax.TaxService;
import com.agileactors.factory.v1.meansoftransportation.Truck;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("TransportationServiceImplV1")
@RequiredArgsConstructor
@Slf4j
public class TransportationServiceImpl implements TransportationService {

  private final TaxService taxService;

  @Override
  public String transportCargo(TransportationDto transportationDto) {
    log.info("Transporting cargo {} of quantity {} and net cost {} via truck...",
        transportationDto.cargo(), transportationDto.quantity(), transportationDto.cost());

    Truck truck = new Truck();

    truck.checkCargo(transportationDto.cargo());

    BigDecimal priceAfterTaxes =
        taxService.applyTaxesOnCargo(transportationDto.cargo(), transportationDto.cost());
    log.info("Final price after taxing is {} ", priceAfterTaxes);

    truck.loadCargo(transportationDto.quantity(), priceAfterTaxes);

    truck.sendToDestination(transportationDto.destination());

    return "Cargo was transported successfully via truck";
  }
}
