package br.com.udemy.config;

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
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.udemy"))  
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"RESTful API With Spring Boot 2.0.3",
				"descricao",
				"v1", 
				"Termos of Service URL", 
				new Contact("Davi", "www.davi.com","davi@gmail.com"),
				"License",
				"License URL", 
				Collections.emptyList());
	}
}
