package taras.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taras.producer.service.KafkaProducerService;
import taras.producer.util.MessageEntity;
import taras.producer.util.Order;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Order order) {
        kafkaProducerService.sendOrderMessage(order);
        return ResponseEntity.ok("Message sent successfully: " + order.toString());
    }
}
