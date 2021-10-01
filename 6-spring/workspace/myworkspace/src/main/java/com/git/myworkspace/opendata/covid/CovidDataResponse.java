package com.git.myworkspace.opendata.covid;

import java.util.List;

import lombok.Data;

@Data
public class CovidDataResponse {
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
		// OLAP Cube �������� ������
		// ����, ī�װ�, �ð�, ��
		// https://gccontent.blob.core.windows.net/gccontent/blogs/legacy/c1/2014/11/OLAP_cube-300x257.png
		private String gubun; // ����

		private String stdDay; // �����Ͻ�

		private String defCnt; // Ȯ���� ��
		private String incDec; // ���� ��� ���� ��
		private String deathCnt; // ����� ��
		private String isolIngCnt; // �ݸ��� ��
		private String localOccCnt; // �����߻� ��
		private String overFlowCnt; // �ؿ����� ��
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
//	<gubun>�˿�</gubun>
//	<gubunCn>̰��ϡ</gubunCn>
//	<gubunEn>Lazaretto</gubunEn>
//	<incDec>9</incDec>
//	<isolClearCnt>5844</isolClearCnt>
//	<isolIngCnt>232</isolIngCnt>
//	<localOccCnt>0</localOccCnt>
//	<overFlowCnt>9</overFlowCnt>
//	<qurRate>-</qurRate>
//	<seq>12416</seq>
//	<stdDay>2021�� 09�� 30�� 00��</stdDay>
//	<updateDt>null</updateDt>
//	</item>
//	
//	
	}
}
