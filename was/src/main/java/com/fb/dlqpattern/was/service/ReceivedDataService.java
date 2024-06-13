package com.fb.dlqpattern.was.service;


import com.fb.dlqpattern.was.domain.ReceivedData;
import com.fb.dlqpattern.was.mapper.ReceivedDataMapper;
import com.fb.dlqpattern.was.rest.ReceivedDataDTO;
import com.fb.dlqpattern.was.util.WasExceptionKonstanten;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.FachlicheWlsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class ReceivedDataService {
    @Value("${service.info.oid}")
    private String serviceOid;

    public void receiveFromDTO(ReceivedDataDTO receivedDataDTO) {
        log.debug("Service aufgerufen");

        if (null == receivedDataDTO
                || receivedDataDTO.id() <= 0
                || receivedDataDTO.age() <= 0
                || StringUtils.isEmpty(receivedDataDTO.name()) || StringUtils.isBlank(receivedDataDTO.name())
                || StringUtils.isEmpty(receivedDataDTO.kind()) || StringUtils.isBlank(receivedDataDTO.kind())) {

            throw FachlicheWlsException.withCode(WasExceptionKonstanten.CODE_REVICEDATA_PARAMETER_UNVOLLSTAENDIG).inService(serviceOid)
                    .buildWithMessage("Das Objekt ReciveData ist nicht vollständig");
        }
        ReceivedData receivedData = ReceivedDataMapper.INSTANCE.toData(receivedDataDTO);
        this.save(receivedData);
    }
    public void save(ReceivedData receivedData) {
        System.out.println("erfolgreich gespeichert");
    }
}
