package com.fb.dlqpattern.was.service;


import com.fb.dlqpattern.was.domain.RevicedData;
import com.fb.dlqpattern.was.mapper.RevicedDataMapper;
import com.fb.dlqpattern.was.rest.RevicedDataDTO;
import com.fb.dlqpattern.was.util.WasExceptionKonstanten;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.FachlicheWlsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class RevicedDataService {
    @Value("${service.info.oid}")
    private String serviceOid;

    public void reviceFromDTO(RevicedDataDTO revicedDataDTO) {
        log.debug("Service aufgerufen");

        if (null == revicedDataDTO
                || revicedDataDTO.id() <= 0
                || revicedDataDTO.age() <= 0
                || StringUtils.isEmpty(revicedDataDTO.name()) || StringUtils.isBlank(revicedDataDTO.name())
                || StringUtils.isEmpty(revicedDataDTO.kind()) || StringUtils.isBlank(revicedDataDTO.kind())) {

            throw FachlicheWlsException.withCode(WasExceptionKonstanten.CODE_REVICEDATA_PARAMETER_UNVOLLSTAENDIG).inService(serviceOid)
                    .buildWithMessage("Das Objekt ReciveData ist nicht vollständig");
        }
        RevicedData revicedData = RevicedDataMapper.INSTANCE.toData(revicedDataDTO);
        this.save(revicedData);
    }
    public void save(RevicedData revicedData) {
        System.out.println("erfolgreich gespeichert");
    }
}
