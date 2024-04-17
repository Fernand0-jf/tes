package com.fernando.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.rabbitmq.dto.User;
import com.fernando.rabbitmq.publisher.RabbitMQJsonProducer;
import com.fernando.rabbitmq.publisher.RabbitMQProducer;

@RestController
@RequestMapping("api/v1")
public class MessageController {
	
	private RabbitMQProducer producer;
	private RabbitMQJsonProducer producer2;

	public MessageController(RabbitMQProducer producer,RabbitMQJsonProducer producer2) {
		this.producer = producer;
		this.producer2 = producer2;
	}
	
	//http://localhost8080/api/v1/publish?message=hello
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessage(message);
		return ResponseEntity.ok("Message sent to RabbitMQ");
	}
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		producer2.sendJsonMessage(user);
		return ResponseEntity.ok("Message Json sent to RabbitMQ");
	}
}
