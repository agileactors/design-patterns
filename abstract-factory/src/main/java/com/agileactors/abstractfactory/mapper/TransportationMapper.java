package com.agileactors.abstractfactory.mapper;

import com.agileactors.abstractfactory.dto.TransportationDto;
import com.agileactors.abstractfactory.dto.TransportationInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransportationMapper {
  TransportationDto toDto(TransportationInput input);
}