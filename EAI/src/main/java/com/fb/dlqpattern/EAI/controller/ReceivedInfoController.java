package com.fb.dlqpattern.EAI.controller;

import com.fb.dlqpattern.EAI.rest.ReceivedInfoDTO;
import com.fb.dlqpattern.EAI.service.ReceivedErgebnismeldungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eai")
public class ReceivedInfoController {

    @Autowired
    ReceivedErgebnismeldungService receivedErgebnismeldungService;

    @GetMapping("/info")
    public String info(@RequestParam(value = "name", defaultValue = "Hello World")String name) {
        return "Noch nicht implementiert." + name;
    }

    @GetMapping("/testgetinfofromeai")
    public String getInforFromEai() {
        return receivedErgebnismeldungService.getInfoFromEai();
    }

    @PostMapping("/sendergebnismeldung")
    public void sendEai(@RequestBody ReceivedInfoDTO info) {
        System.out.println("Im EAI-Controller wurde empfangen:" + info);
        receivedErgebnismeldungService.receiveErgebnismeldungService(info);
    }
}
