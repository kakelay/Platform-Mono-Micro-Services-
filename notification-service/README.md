# Notification Service

`notification-service` manages customer notifications and delivery status.

## Features
- Notification CRUD APIs
- JWT resource server protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl notification-service spring-boot:run -Dspring.profiles.active=dev`
