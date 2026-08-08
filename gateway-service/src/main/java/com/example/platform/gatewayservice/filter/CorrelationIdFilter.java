package com.example.platform.gatewayservice.filter;

import com.example.platform.common.security.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CorrelationIdFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(CorrelationIdFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String correlationId = request.getHeaders().getFirst(SecurityConstants.CORRELATION_ID_HEADER);
        if (correlationId == null || correlationId.isBlank()) {
            correlationId = UUID.randomUUID().toString();
        }
        ServerHttpRequest mutatedRequest = request.mutate()
                .header(SecurityConstants.CORRELATION_ID_HEADER, correlationId)
                .header(SecurityConstants.TRACE_ID_HEADER, UUID.randomUUID().toString())
                .build();
        log.debug("Gateway correlation id set: {} for request {}", correlationId, request.getURI());
        return chain.filter(exchange.mutate().request(mutatedRequest).build())
                .doOnSuccess(aVoid -> exchange.getResponse().getHeaders().add(SecurityConstants.CORRELATION_ID_HEADER, correlationId));
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
