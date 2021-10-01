package com.git.myworkspace.opendata.covid;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CovidSido {
	@Id
	private String gubun; // 지역
	@Id
	private String stdDay; // 기준일시

	private String defCnt; // 확진자 수
	private String incDec; // 전일 대비 증감 수
	private String deathCnt; // 사망자 수
	private String isolIngCnt; // 격리중 수
	private String localOccCnt; // 지역발생 수
	private String overFlowCnt; // 해외유입 수
}
