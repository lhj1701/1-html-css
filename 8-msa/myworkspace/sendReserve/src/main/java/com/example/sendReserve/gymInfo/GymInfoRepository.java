package com.example.sendReserve.gymInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymInfoRepository extends JpaRepository<GymInfo, Long> {
//	List<GymInfo> findById(int id);
}
