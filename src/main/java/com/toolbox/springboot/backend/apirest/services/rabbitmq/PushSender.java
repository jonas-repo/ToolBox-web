package com.toolbox.springboot.backend.apirest.services.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class PushSender {
	
	@Autowired
	private RabbitTemplate rabbitmq;
	
	@Autowired
	private Queue queue;
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send(String message){
		this.rabbitmq.convertAndSend(queue.getName(), message);
		System.out.println(" [x] Sent '" + message + "'");
	}
}
