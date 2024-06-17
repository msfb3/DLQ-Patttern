package com.fb.dlqpattern.ergebnismeldung.controller;


import com.fb.dlqpattern.ergebnismeldung.domain.SendInfo;
import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.service.SendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ergebnismeldung")
public class SendInfoController {

    @Autowired
    SendInfoService sendInfoService;

    @GetMapping("/posts")
    List<SendInfo> findAll {
        return sendInfoService.findAll();
    }

    @PostMapping("")
    public void sendErgebnismeldung(@RequestBody SendInfoDTO info ) {

        sendInfoService.sendInfoFromDTO(info);
    }
}
