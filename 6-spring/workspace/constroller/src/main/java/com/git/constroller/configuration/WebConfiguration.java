package com.git.constroller.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	// CORS(cross origin resource sharing)�� ����
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // ���� ��å�� ������ ���ҽ�, /** : ��ü���ҽ��� ���(/todos, /contacts...)

				// ���� ��å�� ����� ������(Ŭ���̾�Ʈ �ּ�) ���
				// origin(��õ) : html ������ ������ ������ �ּ�
				// html �������� ��� ������ �޾ƿԴ����� ����ϰ� ����
				// ������->����
				.allowedOrigins("http://localhost:3000", "http://127.0.0.1:5500/",
						"http://ec2-3-38-95-168.ap-northeast-2.compute.amazonaws.com")

				// ���� ��å���� ����� HTTP�޼ҵ�
				.allowedMethods("*");// ��ü�޼ҵ带 ���(GET,POST,PUT...)
	}
}
