package com.fb.dlqpattern.EAI.service;

import com.fb.dlqpattern.EAI.domain.SendAlteredInfo;
import com.fb.dlqpattern.EAI.mapper.ReceivedInfoMapper;
import com.fb.dlqpattern.EAI.rest.ReceivedInfoDTO;
import com.fb.dlqpattern.EAI.util.EAIExceptionKonstanten;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.FachlicheWlsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceivedErgebnismeldungService {
    @Value("${service.info.oid}")
    private String serviceOid;
    public void receiveErgebnismeldungService(ReceivedInfoDTO receivedInfoDTO) {

        log.debug("Nachricht erhalten");
        if(null == receivedInfoDTO
                || receivedInfoDTO.id() <= 0
                || receivedInfoDTO.age() <= 0
                || StringUtils.isEmpty(receivedInfoDTO.name()) || StringUtils.isBlank(receivedInfoDTO.name())
                || StringUtils.isEmpty(receivedInfoDTO.kind()) || StringUtils.isBlank(receivedInfoDTO.kind())) {
            throw FachlicheWlsException.withCode(EAIExceptionKonstanten.CODE_SENDINFO_PARAMETER_UNVOLLSTAENDIG).inService(serviceOid)
                    .buildWithMessage("Das Object ReceivedInfoDTO ist nicht vollständig.");
        }

        SendAlteredInfo sendAlteredInfo = ReceivedInfoMapper.INSTANCE.toInfo(receivedInfoDTO);

        this.save(sendAlteredInfo);
    }

    public void save(SendAlteredInfo sendAlteredInfo) {
        System.out.println("erfolgreich gespeichet" + sendAlteredInfo);
    }

}
