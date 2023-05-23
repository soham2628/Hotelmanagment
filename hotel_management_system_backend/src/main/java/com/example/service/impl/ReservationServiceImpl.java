package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Hotel;
import com.example.model.Reservation;
import com.example.model.Room;
import com.example.model.User;
import com.example.repository.HotelRepository;
import com.example.repository.ReservationRepository;
import com.example.repository.RoomRepository;
import com.example.service.ReservationService;
import com.example.service.UserService;


@Service
public class ReservationServiceImpl implements ReservationService{
	private ReservationRepository reservationRepository;
	private HotelRepository hotelRepository;
	@Autowired
	private UserService userService;

	public ReservationServiceImpl(ReservationRepository reservationRepository,HotelRepository hotelRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.hotelRepository=hotelRepository;
	}

	@Override
	public Reservation saveReservation(int userId,Reservation reservation) {
		// TODO Auto-generated method stub
		long hotelId= reservation.getHotelId();
		Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
		existingHotel.setNumberOfRooms(existingHotel.getNumberOfRooms()-1);
		hotelRepository.save(existingHotel);
		return reservationRepository.save(reservation);
		
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(long reservationId) {
		return reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation", "reservationId",reservationId));
	}
	
	public List<Reservation> getReservationByUserId(long userId) {
		return reservationRepository.findByUserId(userId);
				
	}
	public List<Reservation> getReservationByHotelId(long hotelId) {
		return reservationRepository.findByHotelId(hotelId);
	}
	@Override
	public Reservation updateReservation(Reservation reservation, long reservationId) {
		// TODO Auto-generated method stub
		Reservation existingReservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation", "reservationId", reservationId));
		existingReservation.setHotelId(reservation.getHotelId());
		existingReservation.setCheckIn(reservation.getCheckIn());
		existingReservation.setCheckOut(reservation.getCheckOut());
		existingReservation.setUserId(reservation.getUserId());
		existingReservation.setPaymentId(reservation.getPaymentId());
		existingReservation.setPrice(reservation.getPrice());
		reservationRepository.save(existingReservation);
		return existingReservation;
	}

	@Override
	public void deleteReservation(long reservationId) {
		// TODO Auto-generated method stub
		Reservation existingReservation=reservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation", "reservationId",reservationId));
		reservationRepository.deleteById(reservationId);
		long hotelId= existingReservation.getHotelId();
		Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel", "hotelId", hotelId));
		existingHotel.setNumberOfRooms(existingHotel.getNumberOfRooms()+1);
		hotelRepository.save(existingHotel);

	}

}
