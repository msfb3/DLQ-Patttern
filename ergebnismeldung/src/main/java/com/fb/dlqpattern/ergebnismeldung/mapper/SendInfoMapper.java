package com.fb.dlqpattern.ergebnismeldung.mapper;

import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SendInfoMapper {

    SendInfo toEntity(SendInfoDTO sendInfoDTO);

    SendInfoDTO toDTO(SendInfo sendInfo);
}
