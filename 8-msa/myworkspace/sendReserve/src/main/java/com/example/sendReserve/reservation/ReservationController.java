package com.example.sendReserve.reservation;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sendReserve.lib.TextProcesser;

@RestController
public class ReservationController {

	private SendReserveService service;

	private ReservationRepository repo;

	@Autowired
	public ReservationController(ReservationRepository repo, SendReserveService service) {
		this.repo = repo;
		this.service = service;
	}

	@GetMapping(value = "/reservation")
	public List<Reservation> getReservation() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}

	@PostMapping(value = "/reservation")
	public Reservation addReservation(@RequestBody Reservation reservation, HttpServletResponse res)
			throws InterruptedException {

		service.sendReserve(reservation);

		if (TextProcesser.isEmpyText(reservation.getMemberName())) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		Reservation reservationItem = Reservation.builder().id(reservation.getId()).gymName(reservation.getGymName())
				.trainerName(reservation.getTrainerName()).boughtService(reservation.getBoughtService())
				.memberName(reservation.getMemberName()).memberPhone(reservation.getMemberPhone())
				.memberRequest(reservation.getMemberRequest()).build();

		Reservation reservationSaved = repo.save(reservationItem);
		// 리소스 생성됨
		res.setStatus(HttpServletResponse.SC_CREATED);
		// 추가된 객체를 반환
		return reservationSaved;

	}

	@DeleteMapping(value = "/reservation/{id}")
	public boolean removeReservation(@PathVariable long id, HttpServletResponse res) throws InterruptedException {

		Optional<Reservation> reservation = repo.findById(id);
		if (reservation.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// 삭제 수행
		repo.deleteById(id);
		return true;
	}

	@PutMapping(value = "/reservation/{id}")
	public Reservation modifyReservation(@PathVariable long id, @RequestBody Reservation reservation,
			HttpServletResponse res) {

		service.sendReserve(reservation);

		Optional<Reservation> reservationItem = repo.findById(id);
		if (reservationItem.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		if (TextProcesser.isEmpyText(reservation.getMemberName())) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		Reservation reservationToSave = reservationItem.get();

		// 데이터 변경
//		reservationToSave.setGymName(reservation.getGymName());
//		reservationToSave.setTrainerName(reservation.getTrainerName());
//		reservationToSave.setBoughtService(reservation.getBoughtService());
//		reservationToSave.setPrice(reservation.getPrice());
		reservationToSave.setMemberName(reservation.getMemberName());
		reservationToSave.setMemberPhone(reservation.getMemberPhone());
		reservationToSave.setMemberRequest(reservation.getMemberRequest());

		Reservation reservationSaved = repo.save(reservationToSave);
		return reservationSaved;
	}
}
