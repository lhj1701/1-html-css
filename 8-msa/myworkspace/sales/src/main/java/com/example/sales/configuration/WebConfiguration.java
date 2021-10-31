package com.example.sales.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	// CORS(cross origin resource sharing)을 설정
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 공유 정책을 적용할 리소스, /** : 전체리소스를 허용(/todos, /contacts...)

				// 공유 정책을 허용할 오리진(클라이언트 주소) 목록
				// origin(원천) : html 문서를 배포한 서버의 주소
				// html 문서에는 어디서 문서를 받아왔는지를 기록하고 있음
				// 브라우저->서버
				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500/",
						"http://ec2-3-38-95-168.ap-northeast-2.compute.amazonaws.com")

				// 공유 정책으로 허용할 HTTP메소드
				.allowedMethods("*");// 전체메소드를 허용(GET,POST,PUT...)
	}
}
