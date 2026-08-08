# Payment Service

`payment-service` handles payment records and payment status changes.

## Features
- Payment CRUD APIs
- JWT resource server protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl payment-service spring-boot:run -Dspring.profiles.active=dev`
