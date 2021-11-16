package com.example.sendReserve.gymInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GymInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 자동증가값 // 타 시스템에 받은 id값
	private String gymName;
	private String thumbnailUrl;
	private String gymAddress;
	private String gymTime;
	private String trainerName;
}
