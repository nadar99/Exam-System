package com.example.cloudgatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/questions/**")
                        .filters(f -> f.addRequestHeader("question-request","question-request-header")
                                .addResponseHeader("question-response","question-response-header")
                                .circuitBreaker(config -> config.setName("cr")
                                        .setFallbackUri("forward:/fallback/questions")
                                )
                        )
                        .uri("lb://QUESTION-BANK/")

                )  .route(r -> r.path("/api/categories/**")
                        .uri("lb://LOOKUP/")

                )
                .build();
    }
}
