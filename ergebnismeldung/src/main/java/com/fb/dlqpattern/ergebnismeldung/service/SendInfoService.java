package com.fb.dlqpattern.ergebnismeldung.service;

import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.mapper.SendInfoMapper;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.util.ErgebnismeldungExceptionKonstanten;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.FachlicheWlsException;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.WlsException;
import de.muenchen.oss.wahllokalsystem.wls.common.exception.model.WlsExceptionCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.List;

@Slf4j
@Service
@Component
public class SendInfoService {

    RestClient restClient = RestClient.create();
    String uriBase = "http://localhost:39147/ergebnismeldung";


    String result = restClient.get()
            .uri(uriBase + "/infos")
            .retrieve()
            .body(String.class);

    SendInfo sendInfo = new SendInfo(1,"Fabi",26,"Human");
    ResponseEntity<Void> response = restClient.post()
            .uri(uriBase + "/infos")
            .retrieve()
            .toBodilessEntity();

    public List<SendInfo> findAll() {
        RequestEntity<Void> request = RequestEntity.get(URI.create(uriBase + "/infos")).build();

        ResponseEntity<List<SendInfo>> response = (ResponseEntity<List<SendInfo>>) restClient.get();

        return  response.getBody();
    }









    @Value("${service.info.oid}")
    private String serviceOid;


    public void sendInfoFromDTO(SendInfoDTO sendInfoDTO) {

        log.debug("service aufgerufen ");
        if (null == sendInfoDTO
                || sendInfoDTO.id() <= 0
                || sendInfoDTO.age() <= 0
                || StringUtils.isEmpty(sendInfoDTO.name()) || StringUtils.isBlank(sendInfoDTO.name())
                || StringUtils.isEmpty(sendInfoDTO.kind()) || StringUtils.isBlank(sendInfoDTO.kind())) {
            //throw new RuntimeException("bdgbnsghzhz");
            throw FachlicheWlsException.withCode(ErgebnismeldungExceptionKonstanten.CODE_SENDINFO_PARAMETER_UNVOLLSTAENDIG).inService(serviceOid)
                    .buildWithMessage("Das Object SendInfoDTO ist nicht vollständig.");
        }

        SendInfo sendInfo = SendInfoMapper.INSTANCE.toInfo(sendInfoDTO);
        this.save(sendInfo);
    }

    public void save(SendInfo sendInfo) {
        System.out.println("erfolgrich gespeichet" + sendInfo);
    }
}
