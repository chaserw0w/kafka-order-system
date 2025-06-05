#!/bin/bash

echo "⏳ Waiting for Kafka to be ready..."
while ! nc -z kafka 9092; do
  sleep 1
done

echo "✅ Kafka is up. Creating topic..."

kafka-topics --create \
  --topic orders \
  --bootstrap-server kafka:9092 \
  --partitions 1 \
  --replication-factor 1 \
  --if-not-exists

echo "✅ Topic 'orders' created (or already exists)."
