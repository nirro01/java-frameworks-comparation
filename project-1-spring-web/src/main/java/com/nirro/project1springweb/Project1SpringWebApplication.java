package com.nirro.project1springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class Project1SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project1SpringWebApplication.class, args);
	}

}
