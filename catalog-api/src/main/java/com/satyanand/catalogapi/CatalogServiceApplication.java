package com.satyanand.catalogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.satyanand")
@EnableJpaRepositories(basePackages = "com.satyanand.cataloginfrastructure.persistence.repository")
@EntityScan(basePackages = "com.satyanand.cataloginfrastructure.persistence.entity")
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
}
