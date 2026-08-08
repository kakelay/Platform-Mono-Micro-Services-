package com.example.platform.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

        @Bean
        public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route("user-service", r -> r.path("/api/v1/users/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/users/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://user-service"))
                                .route("customer-service", r -> r.path("/api/v1/customers/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/customers/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://customer-service"))
                                .route("account-service", r -> r.path("/api/v1/accounts/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/accounts/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://account-service"))
                                .route("transaction-service", r -> r.path("/api/v1/transactions/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/transactions/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://transaction-service"))
                                .route("payment-service", r -> r.path("/api/v1/payments/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/payments/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://payment-service"))
                                .route("order-service", r -> r.path("/api/v1/orders/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/orders/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://order-service"))
                                .route("notification-service", r -> r.path("/api/v1/notifications/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/notifications/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://notification-service"))
                                .route("document-service", r -> r.path("/api/v1/documents/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/documents/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://document-service"))
                                .route("audit-service", r -> r.path("/api/v1/audits/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/audits/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://audit-service"))
                                .route("reporting-service", r -> r.path("/api/v1/reports/**")
                                                .filters(f -> f.stripPrefix(2)
                                                                .rewritePath("/api/v1/reports/(?<remaining>.*)",
                                                                                "/${remaining}"))
                                                .uri("lb://reporting-service"))
                                .build();
        }
}
