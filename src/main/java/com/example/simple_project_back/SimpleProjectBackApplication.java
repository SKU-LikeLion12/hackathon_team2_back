package com.example.simple_project_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SimpleProjectBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProjectBackApplication.class, args);
	}

}
