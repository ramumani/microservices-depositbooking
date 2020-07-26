package com.ramumani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InterestRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterestRateServiceApplication.class, args);
	}

}
