package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Payment;
import com.example.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // is controller which provides different end points to access the services
public class PaymentController {
	
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;

	}

	// making payement
	@PostMapping("/payment/{userId}/{hotelId}/{reservationId}")
	public ResponseEntity<Payment> addPayment(@PathVariable long userId,@PathVariable long hotelId,@PathVariable long reservationId,@RequestBody Payment payment) {

		return new ResponseEntity<Payment>(paymentService.addPayment(payment, userId, hotelId,reservationId), HttpStatus.CREATED);
	}

	// getting list of payements
	@GetMapping("/allPayments")
	public List<Payment> getAlPayments() {
		return paymentService.getAllPayments();
	}

	// to get payement by payement id(for receipt)

	@GetMapping("/paymentById/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") long paymentId) {
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
	}

	@GetMapping("/payment/Hotel/{hotelId}")
	public List<Payment> getPaymentByHotelId(@PathVariable("hotelId") long hotelId) {
		return paymentService.getAllPaymentsByHotelId(hotelId);
	}

	@GetMapping("/payment/user/{userId}")
	public List<Payment> getPaymentByUserId(@PathVariable("UserId") long UserId) {
		return paymentService.getAllPaymentsByUserId(UserId);
	}

// to delete payement
	@DeleteMapping("/payment/delete/{id}")
	public ResponseEntity<Boolean> deletePayment(@PathVariable("id") long id) {
		paymentService.deletePayment(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
