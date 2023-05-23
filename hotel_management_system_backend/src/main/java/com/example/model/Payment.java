package com.example.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long payementId;

	@Column(name="price")
	private  int price;

	@Column(name="hotelId")
	private  long hotelId;
	
	
	private long userId;

	@Column(name="userName")
	private String userName;

	@Column(name="name")
	private String name;

	@Column(name="district")
	private String district;

	@Column(name="state")
	private String state;

	@Column(name="zip_code")
	private String zipCode;

	@Column(name="contactNumber")
	public long contactNumber;
	
	@Column(name="checkIn")
	private LocalDate checkIn;

	@Column(name="checkOut")
	private LocalDate checkOut;

	@Column(name="name_on_card")
	private String nameOnCard;

	@Column(name="card_number")
	private String cardNumber;

	@Column(name="expiryYear")
	private String expiryYear;

	@Column(name="cvv")
	private int cvv;

	@Column(name="hotel_name")
	private String hotelName;


	@Column(name="paid_date")
	private String paidDate;


	public Payment() {
		super();
	}


	public Payment(long payementId, int price, long hotelId, long userId, String userName, String name, String district,
			String state, String zipCode, long contactNumber, LocalDate checkIn, LocalDate checkOut, String nameOnCard,
			String cardNumber, String expiryYear, int cvv, String hotelName, String paidDate) {
		super();
		this.payementId = payementId;
		this.price = price;
		this.hotelId = hotelId;
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.district = district;
		this.state = state;
		this.zipCode = zipCode;
		this.contactNumber = contactNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expiryYear = expiryYear;
		this.cvv = cvv;
		this.hotelName = hotelName;
		this.paidDate = paidDate;
	}


	public long getPayementId() {
		return payementId;
	}


	public void setPayementId(long payementId) {
		this.payementId = payementId;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public long getHotelId() {
		return hotelId;
	}


	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
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


	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getExpiryYear() {
		return expiryYear;
	}


	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getPaidDate() {
		return paidDate;
	}


	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}


	@Override
	public String toString() {
		return "Payment [payementId=" + payementId + ", price=" + price + ", hotelId=" + hotelId + ", userId=" + userId
				+ ", userName=" + userName + ", name=" + name + ", district=" + district + ", state=" + state
				+ ", zipCode=" + zipCode + ", contactNumber=" + contactNumber + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", expiryYear=" + expiryYear
				+ ", cvv=" + cvv + ", hotelName=" + hotelName + ", paidDate=" + paidDate + "]";
	}

}
