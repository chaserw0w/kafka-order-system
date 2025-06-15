package taras.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import taras.common.domain.Order;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderMessage(Order order) {
        System.out.println("Sending message: " + order.toString());
        kafkaTemplate.send("orders", order);
    }
}
