package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Super Mercado Darwing").version("1.0")
				.description("Documentación Apis para gestionar logica de negocio Super Mercado Darwing"));
	}
}
