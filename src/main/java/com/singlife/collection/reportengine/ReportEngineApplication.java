package com.singlife.collection.reportengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReportEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportEngineApplication.class, args);
	}

}
