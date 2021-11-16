package com.example.gagym.reservation;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendReservationService {
	private RabbitTemplate rabbit;

	private SendReservationService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;

	}

	public void sendReservation(Reservation reservation) {
		System.out.println(reservation);
		rabbit.convertAndSend("sales.product.create", reservation);
	}
}
