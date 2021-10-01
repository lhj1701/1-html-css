package com.git.myworkspace.opendata.air;

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
	private String sidoName; // �е��� Ŀ���� 5%, �������� Ŀ���� 20, �ε��� ����
	@Id
	private String cityName;
	// ��
	private String pm10Value;
	private String pm25Value;
}
