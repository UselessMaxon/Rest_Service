package org.ibs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CreateRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateRestApplication.class, args);
	}

}
