# Redis Infrastructure

This directory contains Redis configuration for caching, distributed locks, and token/session storage.

Recommended settings are managed in `redis.conf` and secrets should be configured outside of version control.

In Docker or Kubernetes, pass `REDIS_PASSWORD` or use a `requirepass` entry through secrets.
