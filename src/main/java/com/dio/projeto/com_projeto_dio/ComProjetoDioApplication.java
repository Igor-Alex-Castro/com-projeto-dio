package com.dio.projeto.com_projeto_dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ComProjetoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComProjetoDioApplication.class, args);
	}

}
