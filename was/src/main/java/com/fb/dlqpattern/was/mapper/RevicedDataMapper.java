package com.fb.dlqpattern.was.mapper;

import com.fb.dlqpattern.was.domain.RevicedData;
import com.fb.dlqpattern.was.rest.RevicedDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RevicedDataMapper {
    RevicedDataMapper INSTANCE = Mappers.getMapper(RevicedDataMapper.class);

    @Mapping(target = "id")
    RevicedData toData(RevicedDataDTO revicedDataDTO);

    @Mapping(target = "id")
    RevicedData toDTO(RevicedData revicedData);

}
