package com.example.sendReserve.reservation;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendReserveService {
	private RabbitTemplate rabbit;

	private SendReserveService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}

	public void sendReserve(Reservation reservation) {
		System.out.println(reservation);
		rabbit.convertAndSend("service.reservation.create", reservation);
	}
}
