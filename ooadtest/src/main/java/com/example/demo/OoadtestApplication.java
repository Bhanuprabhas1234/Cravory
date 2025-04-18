package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OoadtestApplication {
	
	@GetMapping(value="/")
	public String hello() {
		return "<h1>Hi, i am Sunil</h1>";
	}

	public static void main(String[] args) {
		SpringApplication.run(OoadtestApplication.class, args);
	}

}
