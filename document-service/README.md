# Document Service

`document-service` stores document metadata for platform entities.

## Features
- Document CRUD APIs
- JWT resource server protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl document-service spring-boot:run -Dspring.profiles.active=dev`
