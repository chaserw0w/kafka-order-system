package taras.practice.producer_app.src.main.java.taras.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taras.practice.producer_app.src.main.java.taras.producer.service.KafkaProducerService;
import taras.practice.producer_app.src.main.java.taras.producer.util.MessageEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageEntity message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent successfully: " + message;
    }
}
