package com.git.myworkspace.opendata.covid;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CovidData {
	private final String SERVICE_KEY = "LKEbT%2FnJqHz4BIPCLD%2Fj7kAgku8isnaPS%2FsKigDaBX8%2Fqf78ovjrUolSkI%2FM%2BVAP%2FigDrCEBdRj2SyTOREbuqQ%3D%3D";

	// http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=LKEbT%2FnJqHz4BIPCLD%2Fj7kAgku8isnaPS%2FsKigDaBX8%2Fqf78ovjrUolSkI%2FM%2BVAP%2FigDrCEBdRj2SyTOREbuqQ%3D%3D

	@Scheduled(fixedRate = 1000 * 60 * 60 * 1)
	@SuppressWarnings("deprecation")
	public void requestCovidSidoHour() throws IOException {
		System.out.println(new Date().toLocaleString());

		StringBuilder builder = new StringBuilder();
		builder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19");
		builder.append("/getCovid19SidoInfStateJson");
//		builder.append("?startCreateDt=20210930&endCreateDt=20210930");
		builder.append("?serviceKey=" + SERVICE_KEY);

//		System.out.println(builder.toString());

		URL url = new URL(builder.toString());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		byte[] result = con.getInputStream().readAllBytes();

		String data = new String(result);
//		System.out.println(data);

		JSONObject jsonObj = XML.toJSONObject(data);
		String json = jsonObj.toString(2);
//		System.out.println(json);

		CovidDataResponse response = new Gson().fromJson(json, CovidDataResponse.class);
//		System.out.println(response);

		CovidDataResponse.Item item = response.getResponse().getBody().getItems().getItem().get(1);
		System.out.println(item);
	}

}
