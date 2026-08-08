# Order Service

`order-service` manages orders and order lifecycles for customer accounts.

## Features
- Order CRUD APIs
- JWT resource server protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl order-service spring-boot:run -Dspring.profiles.active=dev`
