package com.example.gagym.reservation;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class GymReservationService {
	ReservationRepository repo;

	public GymReservationService(GymReservationService repo) {
		this.repo = (ReservationRepository) repo;
	}

	// 데이터가 갱신되는 시점에 캐시 삭제
	// ex) 타 시스템에서 데이터를 받아와서 저장함
	@CacheEvict(value = "reservation", allEntries = true)
	@RabbitListener(queues = "reservation.info")
	public void receiveSalesProduct(SalesProduct salesProduct) {
		System.out.println(salesProduct);
		saveProduct(salesProduct);
	}

	public Reservation saveProduct(SalesProduct salesProduct) {
		Reservation reservation = Reservation.builder().category(salesProduct.getCategory())
				.productCode(salesProduct.getCode()).productName(salesProduct.getName()).price(salesProduct.getPrice())
				.salesProductId(salesProduct.getId()).build();
		repo.save(product);

		return product;
	}
}
