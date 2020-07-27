package com.ramumani.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxSwagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ramumani")).paths(PathSelectors.ant("/fixeddepositapi/*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Fixed Deposit - Microservices", "Stores/retrives Fixed deposits and calls Interest rate API for fetching real-time rates using service discovery", "API TOS",
				"Terms of service", new Contact("Ramu Mani", "www.ramumani.com", "ramu.mani@company.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

}
