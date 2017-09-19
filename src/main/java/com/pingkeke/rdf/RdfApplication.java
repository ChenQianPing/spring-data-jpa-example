package com.pingkeke.rdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdfApplication.class, args);
	}
}