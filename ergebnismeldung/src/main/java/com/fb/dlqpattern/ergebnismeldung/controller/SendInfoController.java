package com.fb.dlqpattern.ergebnismeldung.controller;


import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.service.SendErgebnismeldungService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendInfoController {

    SendErgebnismeldungService sendErgebnismeldungService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World")String name) {
        return String.format("Hallo %s!", name);
    }

    @PostMapping("/ergebnismeldung")
    public void sendErgebnismeldung(@RequestParam SendInfoDTO body ) {
        sendErgebnismeldungService.sendErgebnismeldung(body);
    }
}
