package taras.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import taras.common.domain.Order;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderMessage(Order order) {
        log.info("Sending message: {}", order);
        kafkaTemplate.send("orders", order);
    }
}
