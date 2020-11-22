package com.nagarjun.ReqSer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Log
@SpringBootApplication
@EnableEurekaClient
public class ReqSerApplication {

	public static void main(String[] args) {
		log.info("INSIDE MAIN METHOD");
		SpringApplication.run(ReqSerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
