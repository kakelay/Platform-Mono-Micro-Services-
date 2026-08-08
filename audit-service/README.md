# Audit Service

`audit-service` stores audit events for platform operations.

## Features
- Audit event API
- JWT resource server protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl audit-service spring-boot:run -Dspring.profiles.active=dev`
