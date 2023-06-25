package com.prueba.backwebsimilar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackWebSimilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackWebSimilarApplication.class, args);
	}

}
