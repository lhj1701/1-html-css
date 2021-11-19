package com.example.sendReserve.trainerInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerInfoController {
	TrainerInfoRepository repo;

	@Autowired
	public TrainerInfoController(TrainerInfoRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/trainer")
	public List<TrainerInfo> getTrainerInfo() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}
}
