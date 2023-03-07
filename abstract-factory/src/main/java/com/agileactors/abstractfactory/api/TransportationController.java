package com.agileactors.abstractfactory.api;

import com.agileactors.abstractfactory.dto.TransportationDto;
import com.agileactors.abstractfactory.dto.TransportationInput;
import com.agileactors.abstractfactory.mapper.TransportationMapper;
import com.agileactors.abstractfactory.service.transportation.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transportation")
public class TransportationController {

  private final TransportationService transportationService;

  private final TransportationMapper transportationMapper;

  @PostMapping(value = "/{era}")
  @ResponseStatus(HttpStatus.OK)
  public String transportCargo(@RequestBody TransportationInput transportationInput,
                               @PathVariable String era) {

    TransportationDto transportationDto = transportationMapper.toDto(transportationInput);

    return transportationService.transportCargo(transportationDto, era);
  }
}
