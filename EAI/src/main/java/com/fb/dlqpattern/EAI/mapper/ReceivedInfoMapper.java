package com.fb.dlqpattern.EAI.mapper;

import com.fb.dlqpattern.EAI.domain.SendAlteredInfo;
import com.fb.dlqpattern.EAI.rest.ReceivedInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceivedInfoMapper {
    ReceivedInfoMapper INSTANCE = Mappers.getMapper(ReceivedInfoMapper.class);

    @Mapping(target = "id")
    SendAlteredInfo toInfo(ReceivedInfoDTO receivedInfoDTO);

    @Mapping(target = "id")
    SendAlteredInfo toDTO(SendAlteredInfo sendAlteredInfo);
}
