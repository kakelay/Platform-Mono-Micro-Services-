# PostgreSQL Infrastructure

This directory contains infrastructure-level configuration and initialization scripts for PostgreSQL containers used by the platform.

## Database ownership
The platform currently uses one PostgreSQL container and one shared database:

- host: `postgres`
- port: `5432`
- database: `platform_master_db`
- username: `platform_user`

All persistence services connect with these values through `DB_HOST`,
`DB_PORT`, `DB_NAME`, `DB_USERNAME`, and `DB_PASSWORD`.

## Initialization
The official PostgreSQL Docker image creates the shared database and user from
`POSTGRES_DB`, `POSTGRES_USER`, and `POSTGRES_PASSWORD`. The included
initialization script intentionally creates no additional databases or roles.

## Migrations
Each service should manage schema migrations with Flyway in `src/main/resources/db/migration/`.
Secrets such as passwords should be passed through environment variables or Docker/Kubernetes secrets, not committed.
