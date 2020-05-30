package com.akki.rest.webservices.restfullwebservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfullWebServicesApplication {
	private static final Logger logger = LoggerFactory.getLogger(RestfullWebServicesApplication.class);

	public static void main(String[] args) {
		logger.info("this is a Rest full WebServices Application class");
		SpringApplication.run(RestfullWebServicesApplication.class, args);
	}

}
