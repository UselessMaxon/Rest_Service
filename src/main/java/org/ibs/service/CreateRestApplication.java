package org.ibs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories
@RestController
public class CreateRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateRestApplication.class, args);
	}

	@RequestMapping("/")
	String index() {
		return "Hello main";

	}

}
