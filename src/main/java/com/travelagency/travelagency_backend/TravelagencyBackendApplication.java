package com.travelagency.travelagency_backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.Mapping;
@SpringBootApplication
@RestController
public class TravelagencyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelagencyBackendApplication.class, args);
	}


	@GetMapping
	public String hello() {
		return "Hello World";
	}
}