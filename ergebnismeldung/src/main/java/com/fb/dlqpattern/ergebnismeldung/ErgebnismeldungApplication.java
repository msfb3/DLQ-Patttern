package com.fb.dlqpattern.ergebnismeldung;

import com.fb.dlqpattern.ergebnismeldung.rest.SendInfoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ErgebnismeldungApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErgebnismeldungApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/ergebnismeldung")
	public void sendErgebnismeldung(@RequestBody SendInfoDTO body ) {

	}
}
