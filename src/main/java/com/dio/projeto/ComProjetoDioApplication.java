package com.dio.projeto;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;




@SpringBootApplication
@EnableFeignClients(basePackages = "com.dio.projeto.service")

public class ComProjetoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComProjetoDioApplication.class, args);
	}

}
