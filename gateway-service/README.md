# Gateway Service

The `gateway-service` is the external API entry point for the platform. It uses Spring Cloud Gateway for routing, security, rate limiting, logging, and correlation ID propagation.

## Features
- API versioning under `/api/v1`
- Route forwarding to user, customer, account, transaction, payment, and order services
- JWT validation via resource server
- Eureka service discovery integration
- Redis-backed rate limiting
- CORS and secure headers
- Global gateway error handling
- Actuator endpoints for health and metrics

## Local Profiles
- `dev` uses local Redis and a default local discovery endpoint
- `uat` and `prod` use environment-based configuration values

## Run
Build with `mvn package`, then run with `-Dspring.profiles.active=dev`.
