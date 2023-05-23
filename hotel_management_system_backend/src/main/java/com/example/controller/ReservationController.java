package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Reservation;
import com.example.service.ReservationService;
@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/reservations/
public class ReservationController {



	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	//http://localhost:8089/api/reservations
	@PostMapping("/reservations/{userId}")
	public ResponseEntity<Reservation> saveReservation(@PathVariable("userId")int userId,@RequestBody Reservation reservation)
	{
		System.out.println(reservation);
		return new ResponseEntity<Reservation>(reservationService.saveReservation(userId,reservation),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/reservations
	@GetMapping("/api/reservations")
	public List<Reservation> getAllReservations()
	{
		return reservationService.getAllReservation();
	}
	//http://localhost:8089/api/reservations/2
	@GetMapping("/api/reservations/{reservationId}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable("reservationId") long reservationId)
	{
		return new ResponseEntity<Reservation>(reservationService.getReservationById(reservationId),HttpStatus.OK);
	}
	@GetMapping("/reservations/user/{userId}")
	public List<Reservation> getReservationByUserID(@PathVariable("userId") long userId)
	{
		return reservationService.getReservationByUserId(userId);
	}
	@GetMapping("/reservations/hotel/{hotelId}")
	public List<Reservation> getReservationByHotelID(@PathVariable("hotelId") long hotelId)
	{
		return reservationService.getReservationByHotelId(hotelId);
	}
	//http://localhost:8089/api/reservations/2
	@PutMapping("/api/reservations/{reservationId}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable("reservationId") long reservationId, @RequestBody Reservation reservation)
	{
		return new ResponseEntity<Reservation> (reservationService.updateReservation(reservation, reservationId),HttpStatus.OK);
	}
	//http://localhost:8089/api/reservations/6
	@DeleteMapping("/api/reservations/{reservationId}")
	public ResponseEntity<String> deleteReservation(@PathVariable("reservationId") long reservationId)
	{
		reservationService.deleteReservation(reservationId);
		return new ResponseEntity<String>("Reservation deleted successfully",HttpStatus.OK);
	}
}

