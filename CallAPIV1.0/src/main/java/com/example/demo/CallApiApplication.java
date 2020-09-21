package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CallApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CallApiApplication.class, args);

	}

}

