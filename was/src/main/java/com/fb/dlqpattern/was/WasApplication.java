package com.fb.dlqpattern.was;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.fb.dlqpattern.was",
		"de.muenchen.oss.wahllokalsystem"
})
public class WasApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasApplication.class, args);
	}

}
