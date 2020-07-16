package com.kumarvicky.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.kumarvicky.demo.models"})
public class FleetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetappApplication.class, args);
	}

}
