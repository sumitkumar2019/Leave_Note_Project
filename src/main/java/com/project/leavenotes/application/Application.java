package com.project.leavenotes.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author sumit
 * 
 *         Start Point configured for Spring Boot Application
 *
 */
@SpringBootApplication(scanBasePackages={"com.project.leavenotes.application"})
public class Application {
	
	//starting point of the app
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
