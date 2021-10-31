package com.git.myworkspace.opendata.covid;

import java.util.List;

import lombok.Data;

@Data
public class CovidSidoDailyResponse {
	private Response response;

	@Data
	public class Response {
		private Header header;
		private Body body;
	}

	@Data
	public class Header {
		private String resultCode;
		private String resultMsg;
	}

	@Data
	public class Body {
		private Items items;
	}

	@Data
	public class Items {
		private List<Item> item;
	}

	@Data
	public class Item {
		// OLAP Cube 형식으로 데이터
		// 지역, 카테고리, 시간, 값
		// https://gccontent.blob.core.windows.net/gccontent/blogs/legacy/c1/2014/11/OLAP_cube-300x257.png
		private String gubun; // 지역

		private String stdDay; // 기준일시

		private String defCnt; // 확진자 수
		private String incDec; // 전일 대비 증감 수
		private String deathCnt; // 사망자 수
		private String isolIngCnt; // 격리중 수
		private String localOccCnt; // 지역발생 수
		private String overFlowCnt; // 해외유입 수
//	<response>
//	<header>
//	<resultCode>00</resultCode>
//	<resultMsg>NORMAL SERVICE.</resultMsg>
//	</header>
//	<body>
//	<items>
//	<item>
//	<createDt>2021-09-30 09:59:13.156</createDt>
//	<deathCnt>15</deathCnt>
//	<defCnt>6091</defCnt>
//	<gubun>검역</gubun>
//	<gubunCn>隔離區</gubunCn>
//	<gubunEn>Lazaretto</gubunEn>
//	<incDec>9</incDec>
//	<isolClearCnt>5844</isolClearCnt>
//	<isolIngCnt>232</isolIngCnt>
//	<localOccCnt>0</localOccCnt>
//	<overFlowCnt>9</overFlowCnt>
//	<qurRate>-</qurRate>
//	<seq>12416</seq>
//	<stdDay>2021년 09월 30일 00시</stdDay>
//	<updateDt>null</updateDt>
//	</item>
//	
//	
	}
}
