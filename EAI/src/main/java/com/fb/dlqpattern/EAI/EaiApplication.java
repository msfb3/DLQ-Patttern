package com.fb.dlqpattern.EAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.fb.dlqpattern.EAI",
		"de.muenchen.oss.wahllokalsystem"
})
public class EaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaiApplication.class, args);
	}

}
