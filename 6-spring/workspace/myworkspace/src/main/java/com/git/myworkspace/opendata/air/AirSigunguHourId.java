package com.git.myworkspace.opendata.air;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirSigunguHourId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String dataTime;
	private String sidoName; // 밀도가 커봤자 5%, 분포도가 커봤자 20, 인덱스 제외
	private String cityName;
}
