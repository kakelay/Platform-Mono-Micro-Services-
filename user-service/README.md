# User Service

`user-service` manages user profile information, preferences, and lifecycle data separate from authentication credentials.

## Features
- CRUD user profile APIs
- JWT resource server for token validation
- Service discovery and actuator health
- Flyway migrations and PostgreSQL ownership

## Run
Use `mvn -pl user-service spring-boot:run -Dspring.profiles.active=dev`
