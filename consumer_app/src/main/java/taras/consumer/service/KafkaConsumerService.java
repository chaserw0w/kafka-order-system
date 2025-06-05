package taras.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import taras.consumer.util.Order;

@Component
public class KafkaConsumerService {

    @KafkaListener(topics = "orders", groupId = "order-consumers")
    public void listen1(ConsumerRecord<String, Order> record) {
        System.out.printf("Consumer 1 Received = Topic: %s, Partition %d, Offset %d, Message: %s%n",
                record.topic(), record.partition(), record.offset(), record.value());
    }

    @KafkaListener(topics = "orders", groupId = "order-consumers")
    public void listen2(ConsumerRecord<String, Order> record) {
        System.out.printf("Consumer 2 Received = Topic: %s, Partition %d, Offset %d, Message: %s%n",
                record.topic(), record.partition(), record.offset(), record.value());
    }
}
