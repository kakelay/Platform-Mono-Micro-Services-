#!/bin/bash
BROKER=localhost:9092
TOPICS=(
  "user.events"
  "customer.events"
  "account.events"
  "transaction.events"
  "payment.events"
  "order.events"
  "notification.events"
  "audit.events"
)

for TOPIC in "${TOPICS[@]}"; do
  kafka-topics.sh --create --topic "$TOPIC" --bootstrap-server "$BROKER" --partitions 3 --replication-factor 1
done
