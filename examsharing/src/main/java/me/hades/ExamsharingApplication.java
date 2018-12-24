package me.hades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"me.hades.controller"})
public class ExamsharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamsharingApplication.class, args);
	}

}

