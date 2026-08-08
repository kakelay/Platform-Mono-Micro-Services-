# Config Service

`config-service` is a centralized Spring Cloud Config Server for the platform.

## Features
- Serves configuration properties to client services
- Supports native configuration from classpath for local development
- Supports external Git-backed configuration for dev/uat/prod
- Exposes actuator endpoints for health and metrics

## Run
Use `mvn spring-boot:run` or package the jar and run with the desired Spring profile.

## Security
Do not store credentials in `application.yml`.
Use environment variables, Kubernetes secrets, or Vault to provide Git credentials.
