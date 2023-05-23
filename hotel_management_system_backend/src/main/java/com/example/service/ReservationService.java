package com.example.service;

import java.util.List;

import com.example.model.Reservation;

public interface ReservationService {
	Reservation saveReservation(int userId,Reservation reservation);
	List<Reservation> getAllReservation();
	Reservation getReservationById(long reservationId);
	List<Reservation> getReservationByUserId(long userId);
	List<Reservation>getReservationByHotelId(long hotelId);
	Reservation updateReservation(Reservation reservation, long reservationId);
	void deleteReservation(long reservationId);
}