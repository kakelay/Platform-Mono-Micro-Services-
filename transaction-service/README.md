# Transaction Service

`transaction-service` manages transaction records, statuses, and account ledger activity.

## Features
- Transaction CRUD APIs
- Resource server JWT protection
- PostgreSQL persistence with Flyway
- Eureka registration and actuator health

## Run
Use `mvn -pl transaction-service spring-boot:run -Dspring.profiles.active=dev`
