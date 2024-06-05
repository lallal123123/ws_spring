package com.example.jpa_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSampleApplication.class, args);
	}

}
