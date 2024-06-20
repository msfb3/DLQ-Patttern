package com.fb.dlqpattern.ergebnismeldung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.fb.dlqpattern.ergebnismeldung",
		"de.muenchen.oss.wahllokalsystem"
})
public class ErgebnismeldungApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErgebnismeldungApplication.class, args);
	}

}
