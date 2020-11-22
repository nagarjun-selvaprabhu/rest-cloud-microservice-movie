package com.nagarjun.cts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.java.Log;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
@Log
public class SwaggerUiConfig extends WebMvcConfigurerAdapter {
	@Bean
	public Docket api() {
		log.info("INSIDE SWAGGER DOCKET");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.nagarjun.cts.controller")).paths(PathSelectors.any())
				.build().apiInfo(getApiInformation()).useDefaultResponseMessages(false);
	}

	private ApiInfo getApiInformation() {
		log.info("INSIDE getApiInformation()");
		return new ApiInfo("Movie Microservice", "This is a Demo API created using Spring Boot", "1.0",
				"API Terms of Service URL", "API License", "API License URL", null);
	}

}
