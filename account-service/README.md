# Account Service

`account-service` manages account lifecycle, balances, and customer-linked account records.

## Features
- Account CRUD APIs
- Resource server JWT protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl account-service spring-boot:run -Dspring.profiles.active=dev`
