package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka.service.KafkaConsumerService;
import com.example.kafka.service.KafkaProducerService;

@RestController
public class KafkaController {

	private final KafkaProducerService producerService;

	public KafkaController(KafkaProducerService producerService) {
		this.producerService = producerService;
	}

	@Autowired
	KafkaConsumerService consumerService;

	@GetMapping("/send/{message}")
	public String sendMessage(@PathVariable(value = "message") String message) {

		producerService.sendMessage(message);
		return " message sent ";
	}

	@GetMapping("/receive")
	public String receiveMessage() {
		String msg = consumerService.getNextMessage();
        return msg != null ? msg : "No messages available";
	}

}
