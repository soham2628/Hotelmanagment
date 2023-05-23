package com.example.service;

import java.util.List;

import com.example.model.Payment;

public interface PaymentService {
	Payment addPayment(Payment payment, long userId, long hotelId, long reservationId);

	List<Payment> getAllPayments();

	Payment getPaymentById(long id);

	void deletePayment(long id);

	public List<Payment> getAllPaymentsByUserId(long userId);

	public List<Payment> getAllPaymentsByHotelId(long hotelId);

}
