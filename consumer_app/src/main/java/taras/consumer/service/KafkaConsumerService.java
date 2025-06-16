package taras.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import taras.common.domain.Order;

@Component
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "orders", groupId = "order-consumers")
    public void listen1(ConsumerRecord<String, Order> record) {
        log.info("Consumer 1 Received = Topic: {}, Partition {}, Offset {}, Message: {}",
                record.topic(), record.partition(), record.offset(), record.value());
    }

    /*          - commented for later //todo: add logic for separate consumers
    @KafkaListener(topics = "orders", groupId = "order-consumers")
    public void listen2(ConsumerRecord<String, Order> record) {
        System.out.printf("Consumer 2 Received = Topic: %s, Partition %d, Offset %d, Message: %s%n",
                record.topic(), record.partition(), record.offset(), record.value());
    }*/
}
