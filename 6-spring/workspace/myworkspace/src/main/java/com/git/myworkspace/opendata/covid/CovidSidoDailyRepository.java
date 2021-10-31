package com.git.myworkspace.opendata.covid;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidSidoDailyRepository extends JpaRepository<CovidSidoDaily, Long> {
	// findBy필드명(파스칼케이스, 대소문자 꼭 잘 맞춰쓸것!)
	// List 가 없으면 최근 1건만 조회됨
	List<CovidSidoDaily> findByGubun(Pageable page, String gubun);
}
