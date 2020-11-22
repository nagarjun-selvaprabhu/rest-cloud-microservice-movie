package com.nagarjun.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.java.Log;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@Log
public class CtsApplication {

	public static void main(String[] args) {
		log.info("INSIDE MAIN METHOD");
		SpringApplication.run(CtsApplication.class, args);
	}
}
