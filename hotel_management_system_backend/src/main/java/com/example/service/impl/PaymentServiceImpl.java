package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.PaymentNotFoundException;
import com.example.model.Hotel;
import com.example.model.Payment;
import com.example.model.Reservation;
import com.example.model.User;
import com.example.repository.PaymentRepository;
import com.example.repository.ReservationRepository;
import com.example.service.HotelService;
import com.example.service.PaymentService;
import com.example.service.ReservationService;
import com.example.service.UserService;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private UserService userService;
	private ReservationRepository reservationRepository;
	private ReservationService reservationService;
	private HotelService hotelService;

	public PaymentServiceImpl(ReservationRepository reservationRepository,PaymentRepository paymentRepository, UserService userService, HotelService hotelService,ReservationService reservationService) {
		super();
		this.paymentRepository = paymentRepository;
		this.reservationRepository=reservationRepository;
		this.userService = userService;
		this.hotelService = hotelService;
		this.reservationService=reservationService;

	}
	@Override
	public Payment addPayment(Payment payment, long userId, long hotelId, long reservationId) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelService.getHotelById(hotelId);
		payment.setHotelName(hotel.getHotelName());
		payment.setPrice(hotel.getPrice());
		User user = userService.getUserById(userId);
		payment.setUserName(user.getUserName());
		payment.setName(user.getName());
		payment.setContactNumber(user.getContactNumber());
		payment.setUserId(userId);
		Reservation reservation=reservationService.getReservationById(reservationId);
		payment=paymentRepository.save(payment);
		reservation.setPaymentId(payment.getPayementId());
		reservation=reservationRepository.save(reservation);
		return payment;
		
	}
	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
	@Override
	public List<Payment> getAllPaymentsByHotelId(long hotelId) {
		return paymentRepository.findByHotelId(hotelId);
	}
	@Override
	public List<Payment> getAllPaymentsByUserId(long userId) {
		return paymentRepository.findByUserId(userId);
	}
	@Override
	public Payment getPaymentById(long paymentId) {
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new PaymentNotFoundException("Payment", "Id", paymentId));
	}
	@Override
	public void deletePayment(long paymentId) {
		paymentRepository.findById(paymentId)
				.orElseThrow(() -> new PaymentNotFoundException("Facilities", "Id", paymentId));
		paymentRepository.deleteById(paymentId);

	}

}
