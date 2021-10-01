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

// @service(����������Ʈ) : �ܺνý��� ���, ������ Ʈ����� ó��
@Service
public class AirService {

	private final String SERVICE_KEY = "LKEbT%2FnJqHz4BIPCLD%2Fj7kAgku8isnaPS%2FsKigDaBX8%2Fqf78ovjrUolSkI%2FM%2BVAP%2FigDrCEBdRj2SyTOREbuqQ%3D%3D";

	private AirSigunguHourRepository repo;

	@Autowired
	public AirService(AirSigunguHourRepository repo) {
		this.repo = repo;
	}

	@SuppressWarnings("deprecation")
	// �ñ����� ����� �ð����� ��ȸ(1�ð����� ����(js, setInterval)
	// fixedRate ���� ó���� ����ǰ� ���ݺ��� �����
	@Scheduled(fixedRate = 1000 * 60 * 60 * 1)
	public void requestAirSigunguHOUR() throws IOException {
		System.out.println(new Date().toLocaleString());

		/*---------������ ��û�ϰ� XML �޾ƿ��� ����------------*/
		// ���ڿ��� ����������� �����ϴ� Ŭ����
		// 1.��û url �����
		StringBuilder builder = new StringBuilder();
		builder.append("http://apis.data.go.kr/B552584"); // ȣ��Ʈ/����Ʈ����
		builder.append("/ArpltnStatsSvc"); // ����
		builder.append("/getCtprvnMesureSidoLIst"); // ��� (�õ�-�ñ�������ȸ) ��: ����-������...�߶���
		builder.append("?sidoName=" + URLEncoder.encode("����", "UTF-8")); // ���︸
		builder.append("&searchCondition=HOUR"); // 1�ð� ����
		builder.append("&pageNo=1&numOfRows=25"); // ������ �� 25��
		builder.append("&serviceKey=" + SERVICE_KEY); // ���� Ű

//		System.out.println(builder.toString());

		// 2.url ��ü ����
		URL url = new URL(builder.toString());

		// 3. Http ���� ����
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// 4. byte[] �迭�� �����͸� �о��
		byte[] result = con.getInputStream().readAllBytes();

		// 5. byte[] -> ���ڿ�(xml) ��ȯ
		String data = new String(result, "UTF-8");
//		System.out.println(data);
		/*---------������ ��û�ϰ� XML �޾ƿ��� ��------------*/

		/*---------xml -> json -> object(java)����------------*/
		// xml(���ڿ�) -> json(��ü)
		JSONObject josnObj = XML.toJSONObject(data);
		// json(��ü) -> json(���ڿ�)
		String json = josnObj.toString(2);
//		System.out.println(json);

		// json(���ڿ�)-> java(object)
		AirSigunguHourResponse response = new Gson().fromJson(json, AirSigunguHourResponse.class);
//		System.out.println(response);

//		// ������ ������
//		AirSiGunGuHourResponse.Item item = response.getResponse().getBody().getItems().getItem().get(1);
//		System.out.println(item);
		/*---------xml -> json -> object(java)��------------*/

		/*---------���䰴ü -> ��ƼƼ ����------------*/
		List<AirSigunguHour> list = new ArrayList<AirSigunguHour>();
		for (AirSigunguHourResponse.Item item : response.getResponse().getBody().getItems().getItem()) {
			AirSigunguHour record = AirSigunguHour.builder().dataTime(item.getDataTime()).sidoName(item.getSidoName())
					.cityName(item.getCityName()).pm10Value(item.getPm10Value()).pm25Value(item.getPm25Value()).build();
			list.add(record);
		}

		/*---------���䰴ü -> ��Ƽ ��------------*/
		/*---------��ƼƼ -> �������͸��� ���� ����-----------*/
		repo.saveAll(list);
		/*---------��ƼƼ -> �������͸��� ���� ��------------*/
	}
}
