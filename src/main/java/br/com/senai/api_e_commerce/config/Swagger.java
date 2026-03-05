package br.com.senai.api_e_commerce.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "E-Commerce",
        version = "1.0",
        description = "API para um sistema de E-commerce"
    )
)

public class Swagger {
    
}
