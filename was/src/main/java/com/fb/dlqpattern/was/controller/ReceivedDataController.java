package com.fb.dlqpattern.was.controller;

import com.fb.dlqpattern.was.rest.ReceivedDataDTO;
import com.fb.dlqpattern.was.service.ReceivedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ReceivedDataController {

    @Autowired
    ReceivedDataService receivedDataService;

    @PostMapping("/was")
    public void receiveData(@RequestBody ReceivedDataDTO receivedDataDTO) {
        receivedDataService.receiveFromDTO(receivedDataDTO);
    }
}
