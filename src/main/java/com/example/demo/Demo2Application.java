package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "/api" })
@EnableJpaRepositories(basePackages = "/api")
@EntityScan(basePackages = "/model")
public class Demo2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
