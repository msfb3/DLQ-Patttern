package com.fb.dlqpattern.ergebnismeldung.service;

import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.mapper.SendInfoMapper;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendInfoService {
    private final SendInfoMapper sendInfoMapper;


    @Autowired
    public SendInfoService(SendInfoMapper sendInfoMapper) {
        this.sendInfoMapper = sendInfoMapper;
        log.debug("Nachricht erhalten");
    }

    public void  getInfoDTOFromInfo(SendInfoDTO sendInfoDTO) {
        SendInfo sendInfo = sendInfoMapper.infoDTOToInfo(sendInfoDTO);
          this.save(sendInfo);
    }

    public void save(SendInfo sendInfo) {
        System.out.println("erfolgrich gespeichet" + sendInfo);
    }
}
