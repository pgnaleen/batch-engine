package com.singlife.collection.batchengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchEngineApplication.class, args);
	}

}
