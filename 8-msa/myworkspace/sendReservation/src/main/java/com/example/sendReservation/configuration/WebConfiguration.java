package com.example.sendReservation.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	// CORS(cross origin resource sharing) 정책을 설정
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				// 공유정책을 적용할 리소스
				.addMapping("/**") // 전체리소스를 허용(/todos, /contacts....)
				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500/",
//							"http://15.164.54.22:3000", "http://15.164.54.22",
						"http://ec2-3-38-95-168.ap-northeast-2.compute.amazonaws.com")
				// 공유정책으로 허용할 HTTP메서드
				.allowedMethods("*"); // 전체메서드를 허용(GET, POST, PUT....)
	}
}
