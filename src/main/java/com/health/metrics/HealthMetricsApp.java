package com.health.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HealthMetricsApp {
	public static void main(String[] args) {
		SpringApplication.run(HealthMetricsApp.class, args);
	}
}
