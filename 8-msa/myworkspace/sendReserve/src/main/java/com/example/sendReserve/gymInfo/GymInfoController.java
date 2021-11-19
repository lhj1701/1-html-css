package com.example.sendReserve.gymInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GymInfoController {

	GymInfoRepository repo;

	@Autowired
	public GymInfoController(GymInfoRepository repo) {
		this.repo = repo;
	}

////	@Cacheable(value = "gyminfo")
//	@GetMapping(value = "/gyminfo/{id}")
//	public GymInfo getGymInfo(@PathVariable long id) {
//		return repo.findById(id).orElse(null);
//	}
//
//	@GetMapping(value = "/gyminfo")
////	public List<GymInfo> getGymInfo() throws InterruptedException {
////		return repo.findAll(Sort.by("id").descending());
////	}
//	public List<GymInfo> getGymInfo() throws InterruptedException {
//		return repo.findAll(Sort.by("id").descending());
//	}
	@GetMapping(value = { "/gyminfo" })
	public List<GymInfo> getGymInfo() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}

}
