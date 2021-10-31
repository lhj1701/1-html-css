package com.git.myworkspace.opendata.air;

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
@Table(indexes = @Index(name = "inx_air_sigungu_hour_1", columnList = "sidoName,cityName"))
@IdClass(AirSigunguHourId.class)
public class AirSigunguHour {
	@Id
	private String dataTime;
	@Id
	@Column(columnDefinition = "varchr(255) collate\"ko_KR.utf8\"")
	private String sidoName; // 밀도가 커봤자 5%, 분포도가 커봤자 20, 인덱스 제외
	@Id
	@Column(columnDefinition = "varchr(255) collate\"ko_KR.utf8\"")
	private String cityName;
	// 값
	private Integer pm10Value;
	private Integer pm25Value;
}
