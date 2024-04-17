package com.fernando.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fernando.rabbitmq.dto.User;

@Service
public class RabbitMQJsonConsumer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	
	@RabbitListener(queues= {"${rabbitmq.jsonQueue.name}"})
	public void consume(User user) {
		LOGGER.info(String.format("Received Json message -> %s", user.toString()));
		
	}
}
