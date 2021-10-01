package com.git.myworkspace.opendata.air;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

// @service(서비스컴포넌트) : 외부시스템 통신, 데이터 트랜잭션 처리
@Service
public class AirService {

	private final String SERVICE_KEY = "LKEbT%2FnJqHz4BIPCLD%2Fj7kAgku8isnaPS%2FsKigDaBX8%2Fqf78ovjrUolSkI%2FM%2BVAP%2FigDrCEBdRj2SyTOREbuqQ%3D%3D";

	private AirSigunguHourRepository repo;

	@Autowired
	public AirService(AirSigunguHourRepository repo) {
		this.repo = repo;
	}

	@SuppressWarnings("deprecation")
	// 시군구별 대기질 시간단위 조회(1시간마다 실행(js, setInterval)
	// fixedRate 가장 처음에 실행되고 간격별로 싫행됨
	@Scheduled(fixedRate = 1000 * 60 * 60 * 1)
	public void requestAirSigunguHOUR() throws IOException {
		System.out.println(new Date().toLocaleString());

		/*---------데이터 요청하고 XML 받아오기 시작------------*/
		// 문자열을 빌더방식으로 생성하는 클래스
		// 1.요청 url 만들기
		StringBuilder builder = new StringBuilder();
		builder.append("http://apis.data.go.kr/B552584"); // 호스트/게이트웨이
		builder.append("/ArpltnStatsSvc"); // 서비스
		builder.append("/getCtprvnMesureSidoLIst"); // 기능 (시도-시군군별조회) 예: 서울-강남구...중랑구
		builder.append("?sidoName=" + URLEncoder.encode("서울", "UTF-8")); // 서울만
		builder.append("&searchCondition=HOUR"); // 1시간 단위
		builder.append("&pageNo=1&numOfRows=25"); // 서울의 구 25개
		builder.append("&serviceKey=" + SERVICE_KEY); // 서비스 키

//		System.out.println(builder.toString());

		// 2.url 객체 생성
		URL url = new URL(builder.toString());

		// 3. Http 접속 생성
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// 4. byte[] 배열로 데이터를 읽어옴
		byte[] result = con.getInputStream().readAllBytes();

		// 5. byte[] -> 문자열(xml) 변환
		String data = new String(result, "UTF-8");
//		System.out.println(data);
		/*---------데이터 요청하고 XML 받아오기 끝------------*/

		/*---------xml -> json -> object(java)시작------------*/
		// xml(문자열) -> json(객체)
		JSONObject josnObj = XML.toJSONObject(data);
		// json(객체) -> json(문자열)
		String json = josnObj.toString(2);
//		System.out.println(json);

		// json(문자열)-> java(object)
		AirSigunguHourResponse response = new Gson().fromJson(json, AirSigunguHourResponse.class);
//		System.out.println(response);

//		// 강동구 데이터
//		AirSiGunGuHourResponse.Item item = response.getResponse().getBody().getItems().getItem().get(1);
//		System.out.println(item);
		/*---------xml -> json -> object(java)끝------------*/

		/*---------응답객체 -> 엔티티 시작------------*/
		List<AirSigunguHour> list = new ArrayList<AirSigunguHour>();
		for (AirSigunguHourResponse.Item item : response.getResponse().getBody().getItems().getItem()) {
			AirSigunguHour record = AirSigunguHour.builder().dataTime(item.getDataTime()).sidoName(item.getSidoName())
					.cityName(item.getCityName()).pm10Value(item.getPm10Value()).pm25Value(item.getPm25Value()).build();
			list.add(record);
		}

		/*---------응답객체 -> 엔티 끝------------*/
		/*---------엔티티 -> 리포지터리로 저장 시직-----------*/
		repo.saveAll(list);
		/*---------엔티티 -> 리포지터리로 저장 끝------------*/
	}
}
