package com.technicalprashikshan.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loggertest")
public class LoggingTestingController {

	private static final Logger logger = LoggerFactory.getLogger(LoggingTestingController.class);

	@RequestMapping("test")
	public String test() {
		logger.info("This from logger");
		return "Testing Spring Boot Default Logger";
	}
}
