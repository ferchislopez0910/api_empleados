package com.parameta.api.empleados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //habilita el modulo de swagger

/**
 * SwaggerConfig is the class that contains the configuration
 * documentation with swagger
 * @author Maria Fernanda Lopez A.
 *
 */
public class SwaggerConfig {
	
	/**
	 * Docket api is the indication for used doc swagger
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.parameta.api.empleados.controllers"))
				.paths(PathSelectors.any())
				.build();
		
	}

}
