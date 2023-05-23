package com.example.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id
	@SequenceGenerator(name="seq_Reservation",sequenceName="ReservationSequence",initialValue=3000,allocationSize=100)
	@GeneratedValue(generator="seq_Reservation")
	private long reservationId;

	@Column(name = "hotelId")
	private long hotelId;

	@Column(name = "checkIn")
	private LocalDate checkIn;

	@Column(name = "checkOut")
	private LocalDate checkOut;
	
	@Column(name="userId")
	private long userId;

	@Column(name = "status")
	private boolean status;

	@Column(name= "paymentId")
	private long paymentId;
	
	@Column(name="price")
	private long price;
	
	protected Reservation() {
		super();
	}

	public Reservation(long reservationId, long hotelId, LocalDate checkIn, LocalDate checkOut, long userId, boolean status,
			long paymentId, long price) {
		super();
		this.reservationId = reservationId;
		this.hotelId = hotelId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.userId = userId;
		this.status = status;
		this.paymentId = paymentId;
		this.price = price;
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", hotelId=" + hotelId + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", userId=" + userId + ", status=" + status + ", paymentId=" + paymentId
				+ ", price=" + price + "]";
	}

}
