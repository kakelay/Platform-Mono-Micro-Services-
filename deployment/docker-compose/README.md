# Docker Compose Environment for Platform Microservices

## Overview

This directory contains a Docker Compose environment for local development of the platform microservices.

Included services:

- PostgreSQL
- Redis
- Kafka + Zookeeper
- Prometheus
- Grafana
- config-service
- discovery-service
- gateway-service
- auth-service
- user-service
- customer-service
- account-service
- transaction-service
- payment-service
- order-service
- notification-service
- document-service
- audit-service
- reporting-service

## Prerequisites

- Docker Engine installed
- Docker Compose v2 (or compatible `docker compose` CLI)
- Maven build artifacts available for service images, or Dockerfiles present in service directories

## Start infrastructure

1. Copy `.env.example` to `.env`.
2. Adjust secrets and database credentials as needed.
3. Run:

```bash
cd deployment/docker-compose
docker compose up -d postgres redis zookeeper kafka prometheus grafana
```

## Start all services

From `deployment/docker-compose`:

```bash
docker compose up -d config-service discovery-service gateway-service auth-service user-service customer-service account-service transaction-service payment-service order-service notification-service document-service audit-service reporting-service
```

## Stop services

From `deployment/docker-compose`:

```bash
docker compose down
```

To remove volumes as well:

```bash
docker compose down -v
```

## View logs

For all services:

```bash
docker compose logs -f
```

For a single service:

```bash
docker compose logs -f gateway-service
```

## Check service health

Use Docker health status:

```bash
docker compose ps
```

Or access the Spring Boot health endpoints:

- `http://localhost:8080/actuator/health` (gateway)
- `http://localhost:8761/actuator/health` (Eureka)
- `http://localhost:8888/actuator/health` (Config Server)

## Check Eureka

Open:

```text
http://localhost:8761
```

## Access Gateway

Open:

```text
http://localhost:8080
```

## Access Grafana

Open:

```text
http://localhost:3000
```

Default Grafana login:

- Username: ``
- Password: `admin`

## Access Prometheus

Open:

```text
http://localhost:9090
```

## Notes

- Services communicate using Docker service names, not `localhost`.
- The Compose network is `platform-net`.
- PostgreSQL, Redis, Kafka, and Grafana use persistent volumes.
- Only ports required for development are exposed.
