package org.generation.redesocial.conecteme.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors
			.basePackage("org.generation.redesocial.conecteme.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(metadata())
			.useDefaultResponseMessages(false)
			.globalResponses(HttpMethod.GET, responseMessage())
			.globalResponses(HttpMethod.POST, responseMessage())
			.globalResponses(HttpMethod.PUT, responseMessage())
			.globalResponses(HttpMethod.DELETE, responseMessage());
				
	}
	
	public static ApiInfo metadata() {
		
		return new ApiInfoBuilder()
			.title("API - B")
			.description("Projeto API Spring - Conecte.me")
			.version("1.0.0")
			.license("Apache License Version 2.0")
			.licenseUrl("https://github.com/alysoncampos")
			.contact(contact())
			.build();
		
	}
	

}