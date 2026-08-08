# Kafka Infrastructure

This directory contains Kafka broker configuration and a helper script for creating platform topics.

Topics should follow the naming pattern:
- user.events
- customer.events
- account.events
- transaction.events
- payment.events
- order.events
- notification.events
- audit.events

Retry and dead-letter handling should be implemented at the consumer layer.
