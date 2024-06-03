package com.fb.dlqpattern.ergebnismeldung.mapper;

import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SendInfoMapper {
    SendInfoMapper INSTANCE = Mappers.getMapper(SendInfoMapper.class);

    @Mapping(target = "id")
    SendInfo toInfo(SendInfoDTO sendInfoDTO);

    @Mapping(target = "id")
    SendInfo toDTO(SendInfo sendInfo);
}
