package taras.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    @KafkaListener(topics = "orders", groupId = "consumer-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.printf("Topic: %s, Partition %d, Offset %d, Message: %s%n",
                record.topic(), record.partition(), record.offset(), record.value());
    }
}
