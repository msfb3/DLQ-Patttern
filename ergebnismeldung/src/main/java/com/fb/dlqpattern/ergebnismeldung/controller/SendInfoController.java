package com.fb.dlqpattern.ergebnismeldung.controller;


import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.service.SendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendInfoController {

    @Autowired
    SendInfoService sendInfoService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World")String name) {
        return String.format("Hallo %s!", name);
    }

    @PostMapping("/ergebnismeldung")
    public void sendErgebnismeldung(@RequestBody SendInfoDTO info ) {

        sendInfoService.sendInfoFromDTO(info);
    }
}
