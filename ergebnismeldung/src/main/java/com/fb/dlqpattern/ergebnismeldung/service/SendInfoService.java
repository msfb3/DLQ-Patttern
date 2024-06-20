package com.fb.dlqpattern.ergebnismeldung.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.mapper.SendInfoMapper;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.util.ErgebnismeldungExceptionKonstanten;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.FachlicheWlsException;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Service
@Component
public class SendInfoService {

    @Value("${service.info.oid}")
    private String serviceOid;

    @Autowired
    SendInfoMapper sendInfoMapper;

    RestClient eaiRestClient = RestClient.create();
    String eaiUriBase = "http://localhost:39148";

    public String getHello(String name) {
        return String.format("Hallo %s!", name);
    }

    public List<SendInfoDTO> getInfos() {
        SendInfo sendInfo1 = new SendInfo(1,"2",3,"4");
        SendInfo sendInfo2 = new SendInfo(1,"2",3,"4");
        List<SendInfoDTO> sendInfoDTOList = new ArrayList<>();
        sendInfoDTOList.add(sendInfoMapper.toDTO(sendInfo1));
        sendInfoDTOList.add(sendInfoMapper.toDTO(sendInfo2));

        return sendInfoDTOList;
    }

    public String getInfoFromEai() {
        System.out.println("ergebnismeldung service getInfoFromEai aufgerufen");
        return eaiRestClient.get().uri(eaiUriBase + "/eai/testgetinfofromeai").retrieve().body(String.class);
    }

    public void sendInfoFromDTO(SendInfoDTO sendInfoDTO) {
        log.debug("service aufgerufen ");
        if (null == sendInfoDTO
                || sendInfoDTO.id() <= 0
                || sendInfoDTO.age() <= 0
                || StringUtils.isEmpty(sendInfoDTO.name()) || StringUtils.isBlank(sendInfoDTO.name())
                || StringUtils.isEmpty(sendInfoDTO.kind()) || StringUtils.isBlank(sendInfoDTO.kind())) {
            throw FachlicheWlsException.withCode(ErgebnismeldungExceptionKonstanten.CODE_SENDINFO_PARAMETER_UNVOLLSTAENDIG).inService(serviceOid)
                    .buildWithMessage("Das Object SendInfoDTO ist nicht vollständig.");
        }

        SendInfo sendInfo = sendInfoMapper.toEntity(sendInfoDTO);

        //dieser save aufruf soll künftig an ein repository in dem die info gespeichert wird
        this.save(sendInfo);

        eaiRestClient.post().uri(eaiUriBase + "/eai/sendergebnismeldung").contentType(APPLICATION_JSON)
                .body(sendInfoDTO)
                .retrieve()
                .toBodilessEntity();
    }

    public void save(SendInfo sendInfo) {
        System.out.println("erfolgrich gespeichet" + sendInfo);
    }


}
