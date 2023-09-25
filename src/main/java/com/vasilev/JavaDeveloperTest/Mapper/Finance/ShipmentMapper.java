package com.vasilev.JavaDeveloperTest.Mapper.Finance;

import com.vasilev.JavaDeveloperTest.DTO.ShipmentDto;
import com.vasilev.JavaDeveloperTest.Entity.Shipment;

import com.vasilev.JavaDeveloperTest.Mapper.DtoMapper;
import com.vasilev.JavaDeveloperTest.Mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipmentMapper extends EntityMapper<ShipmentDto, Shipment>, DtoMapper<Shipment, ShipmentDto> {
}
