package com.test.studentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
             .info(new Info()
             .title("Student Service API")
             .version("1.0")
             .description("API for processing student eligibility for scholarship based on their marks")
             );
    }
}
