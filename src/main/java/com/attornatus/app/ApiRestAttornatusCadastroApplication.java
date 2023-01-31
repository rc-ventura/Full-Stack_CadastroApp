package com.attornatus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.attornatus.app"})
@EntityScan(basePackages ={"com.attornatus.app.Entities"})
@EnableAutoConfiguration
public class ApiRestAttornatusCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestAttornatusCadastroApplication.class, args);
	}

}
