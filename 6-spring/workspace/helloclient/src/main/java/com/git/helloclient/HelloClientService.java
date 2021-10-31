package com.git.helloclient;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloClientService {

	@RabbitListener(queues = "test.hello.2")
	public void receiveMessage(String message) {
//		System.out.println("--test.help.2--");
		System.out.println(message);
	}
}
