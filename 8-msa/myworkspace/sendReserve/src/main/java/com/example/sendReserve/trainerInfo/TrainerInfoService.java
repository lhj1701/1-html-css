package com.example.sendReserve.trainerInfo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TrainerInfoService {

	TrainerInfoRepository repo;

	public TrainerInfoService(TrainerInfoRepository repo) {
		this.repo = repo;
	}

	@RabbitListener(queues = "service.trainer.create2")
	public void getTrainerInfo(TrainerInfo trainerInfo) {
		System.out.println(trainerInfo);
		saveTrainerInfo(trainerInfo);
	}

	public TrainerInfo saveTrainerInfo(TrainerInfo trainerInfo) {
		TrainerInfo saveTrainerInfo = TrainerInfo.builder().gymCode(trainerInfo.getGymCode())
				.trainerName(trainerInfo.getTrainerName()).build();
		repo.save(saveTrainerInfo);

		return saveTrainerInfo;
	}
}
