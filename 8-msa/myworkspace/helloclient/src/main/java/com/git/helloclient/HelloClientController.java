package com.git.helloclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class HelloClientController {

	private HelloClientService service;

	private Map<String, String> clientConnectedMap = new HashMap<String, String>();

	@Autowired
	public void HelloClientController(HelloClientService service) {
		this.service = service;
	}

	// sever sent event 프로토콜로 처리할 때는 반환타입이 sseEmitter
	@GetMapping(value = "/event/{clientId}")
	public SseEmitter connectEvent(@PathVariable String clientId) {

		// event를 발생시키는 객체를 생성
		SseEmitter emitter = new SseEmitter();

		service.putEmitter(clientId, emitter);
		try {
			emitter.send("--connected--");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 5초 후에 보내기
//		emitMessage(emitter);
		return emitter;
	}

//	private void emitMessage(SseEmitter emitter) {
	// lamda 스타일 함수 표기법
//		Runnable thread = () -> {
//			try {
//				Thread.sleep(5000);
//				try {
//					emitter.send("new event message");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			} catch (InterruptedException e) {
//			e.printStackTrace();
//			}
//		}
//	new Thread(thread).start();
//	}
}
