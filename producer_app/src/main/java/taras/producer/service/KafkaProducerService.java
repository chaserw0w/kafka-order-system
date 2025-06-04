package taras.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import taras.producer.util.MessageEntity;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(MessageEntity messageEntity) {
        kafkaTemplate.send("orders", messageEntity.message());
    }
}
