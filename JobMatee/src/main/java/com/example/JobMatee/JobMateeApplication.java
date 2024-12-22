package com.example.JobMatee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.JobMatee")
@EntityScan("com.example.JobMatee.model")

public class JobMateeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobMateeApplication.class, args);
	}

}
