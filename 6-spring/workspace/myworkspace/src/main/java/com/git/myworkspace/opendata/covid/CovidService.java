package com.git.myworkspace.opendata.covid;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CovidService {
	private final String SERVICE_KEY = "LKEbT%2FnJqHz4BIPCLD%2Fj7kAgku8isnaPS%2FsKigDaBX8%2Fqf78ovjrUolSkI%2FM%2BVAP%2FigDrCEBdRj2SyTOREbuqQ%3D%3D";

	// http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=LKEbT%2FnJqHz4BIPCLD%2Fj7kAgku8isnaPS%2FsKigDaBX8%2Fqf78ovjrUolSkI%2FM%2BVAP%2FigDrCEBdRj2SyTOREbuqQ%3D%3D

	private CovidSidoDailyRepository repo;

	@Autowired
	public CovidService(CovidSidoDailyRepository repo) {
		this.repo = repo;
	}

	// 매시 30분에 실행 (cron = "0 30 * * * *") (초 분 시 일 월 년)
	// 그럼 아래는 매일 오전 열시 5분
//	@Scheduled(cron = "0 5 10 * * *")
	@Scheduled(fixedRate = 1000 * 60 * 60 * 1)

	// 스프링내부적으로 네임/값을 나눠서 새로 데이터가 갱신되는 시점(함수가 실행되는 시점)에 네임만 남기고 값을 밀어버림
	@CacheEvict(value = "covid-current", allEntries = true)
	@SuppressWarnings("deprecation")
	public void requestCovidSidoHour() throws IOException {
		System.out.println(new Date().toLocaleString());

		StringBuilder builder = new StringBuilder();
		builder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19");
		builder.append("/getCovid19SidoInfStateJson");
//		builder.append("?startCreateDt=20210930&endCreateDt=20210930");
		builder.append("?serviceKey=" + SERVICE_KEY);

		System.out.println(builder.toString());

		URL url = new URL(builder.toString());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		byte[] result = con.getInputStream().readAllBytes();

		String data = new String(result);
//		System.out.println(data);

		JSONObject jsonObj = XML.toJSONObject(data);
		String json = jsonObj.toString(2);
//		System.out.println(json);

		CovidSidoDailyResponse response = new Gson().fromJson(json, CovidSidoDailyResponse.class);
//		System.out.println(response);

		// 제주 데이터 조회
//		CovidDataResponse.Item item = response.getResponse().getBody().getItems().getItem().get(1);
//		System.out.println(item);

		List<CovidSidoDaily> list = new ArrayList<CovidSidoDaily>();
		for (CovidSidoDailyResponse.Item item : response.getResponse().getBody().getItems().getItem()) {
			CovidSidoDaily record = CovidSidoDaily.builder().gubun(item.getGubun()).stdDay(item.getStdDay())
					.defCnt(item.getDefCnt().isEmpty() ? null : Integer.valueOf(item.getDefCnt()))
					.incDec(item.getIncDec().isEmpty() ? null : Integer.valueOf(item.getIncDec()))
					.deathCnt(item.getDeathCnt().isEmpty() ? null : Integer.valueOf(item.getDeathCnt()))
					.isolIngCnt(item.getIsolIngCnt().isEmpty() ? null : Integer.valueOf(item.getIsolIngCnt()))
					.localOccCnt(item.getLocalOccCnt().isEmpty() ? null : Integer.valueOf(item.getLocalOccCnt()))
					.overFlowCnt(item.getOverFlowCnt().isEmpty() ? null : Integer.valueOf(item.getOverFlowCnt()))
					.build();
			list.add(record);
		}
		repo.saveAll(list);
	}

}
