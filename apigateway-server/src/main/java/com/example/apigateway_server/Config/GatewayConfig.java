//package com.example.apigateway_server.Config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//	    @Bean
//	    RouteLocator customRoutes(RouteLocatorBuilder builder) {
//	        return builder.routes()
//	        		.route("auth-service",r->r.path("/auth/**")
//	                        .uri("http://localhost:8081"))
//	                .route("category-server", r -> r.path("/category/**")
//	                        .uri("http://localhost:8083"))
//	                .route("expenses-server", r -> r.path("/expenses/**")
//	                        .uri("http://localhost:8082"))
//	                .build();
//	    }
//	}
//
//
