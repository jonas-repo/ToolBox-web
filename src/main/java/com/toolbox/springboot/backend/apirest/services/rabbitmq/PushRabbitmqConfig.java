package com.toolbox.springboot.backend.apirest.services.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PushRabbitmqConfig {
	
	@Bean
	public Queue hello() {
		return new Queue("Hello");
	}
	
	@Profile("receiver")
	@Bean
	public PushReceiver receiver() {
		return new PushReceiver();
	}
	
	@Profile("sender")
	@Bean
	public PushSender sender(String message) {
		return new PushSender();
	}
}
