package com.fb.dlqpattern.ergebnismeldung.mapper;

import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SendInfoMapper {
    SendInfoDTO infoToInfoDTO(SendInfo sendInfo);
    SendInfo infoDTOToInfo(SendInfoDTO sendInfoDTO);

    @Mapping(target = "id", ignore = true)
    SendInfoDTO createInfoDTOWithoutId(SendInfo sendInfo);
}
