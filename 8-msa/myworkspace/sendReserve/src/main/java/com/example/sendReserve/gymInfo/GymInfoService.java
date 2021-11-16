package com.example.sendReserve.gymInfo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class GymInfoService {

	GymInfoRepository repo;

	public GymInfoService(GymInfoRepository repo) {
		this.repo = repo;
	}

	// 데이터가 갱신되는 시점에 캐시 삭제
	// ex) 타 시스템에서 데이터를 받아와서 저장함
//	@CacheEvict(value = "gyminfo", allEntries = true)
	@RabbitListener(queues = "service.gym.create")
	public void getGymInfo(GymInfo gymInfo) {
		System.out.println(gymInfo);
		saveGymInfo(gymInfo);
	}

	public GymInfo saveGymInfo(GymInfo gymInfo) {
		GymInfo saveGymInfo = GymInfo.builder().gymName(gymInfo.getGymName()).gymAddress(gymInfo.getGymAddress())
				.gymTime(gymInfo.getGymTime()).thumbnailUrl(gymInfo.getThumbnailUrl())
				.trainerName(gymInfo.getTrainerName()).build();
		repo.save(saveGymInfo);

		return saveGymInfo;
	}
}
