package com.git.helloclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class HelloClientService {

	private Map<String, SseEmitter> emitters = new HashMap<String, SseEmitter>();

	public void putEmitter(String clientId, SseEmitter emitter) {
		this.emitters.put(clientId, emitter);
	}

	@RabbitListener(queues = "test.hello.2")
	public void receiveMessage(String message) throws UnsupportedEncodingException {
//		System.out.println("--test.help.2--");
		System.out.println(message);

		emitters.values().parallelStream().forEach(emitter -> {
			try {
				emitter.send(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
