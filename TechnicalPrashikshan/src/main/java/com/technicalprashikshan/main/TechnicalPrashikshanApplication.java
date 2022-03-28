package com.technicalprashikshan.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechnicalPrashikshanApplication {
	private static final Logger logger = LoggerFactory.getLogger(TechnicalPrashikshanApplication.class);

	public static void main(String[] args) {
		logger.info("Start! ");

		logger.info("logger is configured successfully!");
		SpringApplication.run(TechnicalPrashikshanApplication.class, args);
		logger.info("Spring Boot application is deployed successfully!!");
		logger.info("End!");
	}

}
