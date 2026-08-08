# Auth Service

`auth-service` is the centralized authentication and authorization service for the platform.

## Features
- JWT access and refresh tokens
- Login, logout, refresh token, register
- Password hashing with BCrypt
- Role-based authorization design
- OAuth2 / resource server readiness
- Service discovery registration with Eureka
- Health checks via Actuator
- Flyway database migrations

## Run
Build and run with: `mvn -pl auth-service spring-boot:run -Dspring.profiles.active=dev`

## Notes
Use secure secrets for `SECURITY_JWT_SECRET`, database credentials, and production configuration.
