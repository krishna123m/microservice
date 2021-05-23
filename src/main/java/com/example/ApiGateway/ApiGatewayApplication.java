package com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		
		return builder.routes().route(r -> r.path("/getCurrencyConversion/**")
				// .filters(f->f.addRequestHeader("isAuthenticated", "yes"))
				// .uri("lb://CURRENCY-CONVERSION")
				.uri("http://localhost:8100/")

		).route(r -> r.path("/getCurrencyConversion-feign/**")
				.filters(f->f.addRequestHeader("isAuthenticated", "Yes"))
				.uri("http://localhost:8100/")).build();
		
		
	}
}
