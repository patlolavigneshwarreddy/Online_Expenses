package com.example.kafka.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private final BlockingQueue<String> messages = new LinkedBlockingQueue<>();
 
	@KafkaListener(topics = "my_topic", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Message received: " + message);
	   messages.add(message); // store messages in memory
	}
	
	public String getNextMessage() {
        return messages.poll(); // returns null if no message
    }
	
	
}
