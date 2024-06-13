package com.fb.dlqpattern.was.mapper;

import com.fb.dlqpattern.was.domain.ReceivedData;
import com.fb.dlqpattern.was.rest.ReceivedDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceivedDataMapper {
    ReceivedDataMapper INSTANCE = Mappers.getMapper(ReceivedDataMapper.class);

    @Mapping(target = "id")
    ReceivedData toData(ReceivedDataDTO receivedDataDTO);

    @Mapping(target = "id")
    ReceivedData toDTO(ReceivedData receivedData);

}
