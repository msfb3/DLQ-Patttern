package com.fb.dlqpattern.EAI.controller;

import com.fb.dlqpattern.EAI.service.ReceivedErgebnismeldungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ReceivedInfoController {
    @Autowired
    ReceivedErgebnismeldungService receivedErgebnismeldungService;

    @GetMapping("/info")
    public String info(@RequestParam(value = "name", defaultValue = "World")String name) {
        return receivedErgebnismeldungService.receiveErgebnismeldungService(name);
    }
}
