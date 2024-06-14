package com.fb.dlqpattern.EAI.controller;

import com.fb.dlqpattern.EAI.rest.ReceivedInfoDTO;
import com.fb.dlqpattern.EAI.service.ReceivedErgebnismeldungService;
import org.springframework.web.bind.annotation.*;

@RestController

public class ReceivedInfoController {

    ReceivedErgebnismeldungService receivedErgebnismeldungService;

    @GetMapping("/info")
    public String info(@RequestParam(value = "name", defaultValue = "Hello World")String name) {
        return String.format("Noch nicht implementiert:", name);
    }

    @PostMapping("/eai")
    public void sendEai(@RequestBody ReceivedInfoDTO info) {
        receivedErgebnismeldungService.receiveErgebnismeldungService(info);
    }
}
