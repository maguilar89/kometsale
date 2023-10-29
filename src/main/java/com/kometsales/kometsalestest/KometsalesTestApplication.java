package com.kometsales.kometsalestest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.kometsales.kometsalestest.infrastructure.persistence.repository")
@SpringBootApplication
public class KometsalesTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KometsalesTestApplication.class, args);
	}

}
