package com.vasilev.JavaDeveloperTest.Mapper.Finance;

import com.vasilev.JavaDeveloperTest.DTO.PriceDto;
import com.vasilev.JavaDeveloperTest.Entity.Price;
import com.vasilev.JavaDeveloperTest.Mapper.DtoMapper;
import com.vasilev.JavaDeveloperTest.Mapper.EntityMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceDto, Price>, DtoMapper<Price,PriceDto> {
}
