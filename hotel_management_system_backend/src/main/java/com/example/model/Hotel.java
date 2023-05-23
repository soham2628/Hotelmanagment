package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@SequenceGenerator(name="seq_Hotel",sequenceName="HotelSequence",initialValue=1000,allocationSize=100)
	@GeneratedValue(generator="seq_Hotel")
	@Column(name = "hotel_id")
	private long hotelId;

	@Column(name = "hotel_name")
	private String hotelName;
	@Column(name = "address")
	private String address;
	@Column(name = "num_rooms")
	private int numberOfRooms;
	@Column(name= "price")
	private int price;
	// One hotel has many room
	public Hotel() {
		super();
	}
	public Hotel(long hotelId, String hotelName, String address, int numberOfRooms, int price, List<Room> rooms) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.numberOfRooms = numberOfRooms;
		this.price = price;
	}

	

	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Hotel [HotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", numberOfRooms="
				+ numberOfRooms + ", price=" + price + "]";
	}
	
}
