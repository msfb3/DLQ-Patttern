package com.fb.dlqpattern.ergebnismeldung;

import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import com.fb.dlqpattern.ergebnismeldung.service.SendErgebnismeldungService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class ErgebnismeldungApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErgebnismeldungApplication.class, args);
	}

}
