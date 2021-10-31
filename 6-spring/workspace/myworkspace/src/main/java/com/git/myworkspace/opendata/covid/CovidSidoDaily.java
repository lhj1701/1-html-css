package com.git.myworkspace.opendata.covid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(indexes = @Index(name = "inx_covid_sido_daily", columnList = "gubun, stdDay"))
@IdClass(CovidSidoDailyId.class)
public class CovidSidoDaily {
	@Id
	@Column(columnDefinition = "varchar(255) collate\"ko_KR.utf8\"")
	private String gubun; // 지역
	@Id
//	@Column(columnDefinition = "varchar(255) collate\"ko_KR.utf8\"")
	private String stdDay; // 기준일시

	private Integer defCnt; // 확진자 수
	private Integer incDec; // 전일 대비 증감 수
	private Integer deathCnt; // 사망자 수
	private Integer isolIngCnt; // 격리중 수
	private Integer localOccCnt; // 지역발생 수
	private Integer overFlowCnt; // 해외유입 수
}
