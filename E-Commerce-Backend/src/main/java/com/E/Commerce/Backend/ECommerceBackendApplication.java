package com.E.Commerce.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ECommerceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceBackendApplication.class, args);
	}


}

