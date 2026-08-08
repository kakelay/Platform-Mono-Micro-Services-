# Prometheus Infrastructure

This directory contains the Prometheus configuration for scraping Spring Boot actuator metrics and Kafka/JVM endpoints.

Use the `prometheus.yml` file as the main configuration for Docker Compose and Kubernetes deployments.

Prometheus should be configured to scrape:
- gateway-service actuator metrics
- auth-service actuator metrics
- business services actuator metrics
- Kafka broker metrics if exposed
