package com.example.platform.gatewayservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Map;

@Component
@Order(-2)
public class GatewayErrorWebExceptionHandler implements ErrorWebExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GatewayErrorWebExceptionHandler.class);

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error("Gateway exception handled", ex);
        var response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        var body = Map.of(
                "success", false,
                "code", "GATEWAY_ERROR",
                "message", ex.getMessage(),
                "data", null,
                "timestamp", OffsetDateTime.now().toString(),
                "traceId", exchange.getRequest().getHeaders().getFirst("X-Trace-Id"));

        return response.writeWith(Mono.just(response.bufferFactory().wrap(new Jackson2JsonEncoder()
                .encodeValue(body, response.bufferFactory(), ResolvableType.forInstance(body),
                        MediaType.APPLICATION_JSON, Map.of())
                .asByteBuffer())));
    }
}
