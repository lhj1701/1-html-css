package com.example.sendReserve.trainerInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainerInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	private String gymCoNum;
	private String gymCode;
//	@Column(columnDefinition = "VARCHAR(1000)")
	private String trainerName;
}
