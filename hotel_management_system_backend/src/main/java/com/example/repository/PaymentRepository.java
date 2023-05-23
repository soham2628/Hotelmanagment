package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
	public List<Payment> findByUserId(long userId);
	public List<Payment> findByHotelId(long hotelId);
}
