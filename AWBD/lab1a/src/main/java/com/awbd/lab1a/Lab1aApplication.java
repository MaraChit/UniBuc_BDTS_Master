package com.awbd.lab1a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Lab1aApplication {

	@RequestMapping("/home")
	public String home(){return "Hello world!";}
	public static void main(String[] args) {
		SpringApplication.run(Lab1aApplication.class, args);
	}

}
