# PostgreSQL Infrastructure

This directory contains infrastructure-level configuration and initialization scripts for PostgreSQL containers used by the platform.

## Database ownership
Each microservice should use its own PostgreSQL database and service-specific credentials.

Example databases:
- platform_auth_db
- platform_user_db
- platform_customer_db
- platform_account_db
- platform_transaction_db
- platform_payment_db
- platform_order_db
- platform_notification_db
- platform_document_db
- platform_audit_db
- platform_reporting_db

## Initialization
Place initialization SQL in `docker-entrypoint-initdb.d/` so the official PostgreSQL Docker image creates the databases and users at container startup.

## Migrations
Each service should manage schema migrations with Flyway in `src/main/resources/db/migration/`.
Secrets such as passwords should be passed through environment variables or Docker/Kubernetes secrets, not committed.
