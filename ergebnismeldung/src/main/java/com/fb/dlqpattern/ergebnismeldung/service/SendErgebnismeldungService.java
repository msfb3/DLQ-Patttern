package com.fb.dlqpattern.ergebnismeldung.service;

import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendErgebnismeldungService {
    public void sendErgebnismeldung(SendInfoDTO body) {
        log.debug("Nachricht erhalten");
    }
}
