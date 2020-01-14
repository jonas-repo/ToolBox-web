package com.toolbox.springboot.backend.apirest.services.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "toolbox_web")
public class PushReceiver {
	
	@RabbitHandler
	public void receiver(String message) {
		System.out.println(" [x] Received '" + message + "'");
	}
}
