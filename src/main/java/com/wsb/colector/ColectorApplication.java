package com.wsb.colector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ColectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColectorApplication.class, args);
	}

	@GetMapping
	public String sayHi(){
		return "witam serdecznie";
	}
}
