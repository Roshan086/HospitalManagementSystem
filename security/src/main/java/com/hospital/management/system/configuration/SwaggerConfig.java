package com.hospital.management.system.configuration;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;*/



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)//
	        .select()//
	        .apis(RequestHandlerSelectors.any())//
	        .paths(Predicates.not(PathSelectors.regex("/error")))//
	        .build()//
	        .apiInfo(metadata())//
	        .useDefaultResponseMessages(false)//
	        .securitySchemes(Collections.singletonList(apiKey()))
	        .securityContexts(Collections.singletonList(securityContext()))
	        .tags(new Tag("users", "Operations about users"))//
	        .genericModelSubstitutes(Optional.class);

	  }

	  private ApiInfo metadata() {
	    return new ApiInfoBuilder()//
	        .title("JSON Web Token Authentication API")//
	        .description("This is a sample JWT authentication service. you should click on the right top button `Authorize` and introduce it with the prefix \"Bearer \".")//
	        .version("1.0.0")//
	        .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
	        .contact(new Contact(null, null, "roshankumar@gmail.com"))//
	        .build();
	  }
	  
	  private ApiKey apiKey() {
	    return new ApiKey("Authorization", "Authorization", "header");
	  }

	  private SecurityContext securityContext() {
	    return SecurityContext.builder()
	        .securityReferences(defaultAuth())
	        .forPaths(PathSelectors.any())
	        .build();
	  }

	  private List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
	  }
	  
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .paths(PathSelectors.any())
	 * .apis(RequestHandlerSelectors.basePackage("com.springboot.jwt")) .build()
	 * .apiInfo(apiEndPointInfo()); }
	 * 
	 * private ApiInfo apiEndPointInfo() { return new
	 * ApiInfoBuilder().title("Demp Project") .description("Demo Project")
	 * .contact(new
	 * Contact("Roshan kumar","www.systemsltd.com","roshan.kumar@systemsltd.com"))
	 * .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	 * .version("1.0.0") .build(); }
	 */
}
