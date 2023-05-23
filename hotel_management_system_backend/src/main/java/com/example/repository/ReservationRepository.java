package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {
	List<Reservation> findByHotelId(long hotelId);
	List<Reservation> findByUserId(long userId);
}
