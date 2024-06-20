package com.fb.dlqpattern.ergebnismeldung.controller;



import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.service.SendInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ergebnismeldung")
public class SendInfoController {

    @Autowired
    SendInfoService sendInfoService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World")String name) {
        return sendInfoService.getHello(name);
    }

    @GetMapping("/infos")
    public List<SendInfoDTO> getInfos() {
        return sendInfoService.getInfos();
    }

    @GetMapping("/testgetinfofromeai")
    public String getInfoFromEai() {
        return sendInfoService.getInfoFromEai();
    }

    @PostMapping("/sendergebnismeldung")
    public void sendErgebnismeldung(@RequestBody SendInfoDTO info ) {
        log.debug("Info empfangen: {}", info.name());
        sendInfoService.sendInfoFromDTO(info);
    }
}
