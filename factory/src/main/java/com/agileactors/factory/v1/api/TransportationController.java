package com.agileactors.factory.v1.api;

import com.agileactors.factory.common.dto.TransportationDto;
import com.agileactors.factory.common.dto.TransportationInput;
import com.agileactors.factory.common.mapper.TransportationMapper;
import com.agileactors.factory.v1.service.transportation.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("TransportationControllerV1")
@RequestMapping("/api/v1/transportation")
public class TransportationController {

  private final TransportationService transportationService;

  private final TransportationMapper transportationMapper;


  @PostMapping(value = "/")
  @ResponseStatus(HttpStatus.OK)
  public String transportCargo(@RequestBody TransportationInput transportationInput) {

    TransportationDto transportationDto = transportationMapper.toDto(transportationInput);

    return transportationService.transportCargo(transportationDto);
  }
}
