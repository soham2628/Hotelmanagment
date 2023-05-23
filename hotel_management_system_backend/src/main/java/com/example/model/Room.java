package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name="Room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id" )
	private Hotel hotel;
	
	@OneToOne
	@JoinColumn(name = "hotelid")
	private RoomCount roomCount=new RoomCount(hotel.getHotelId(), 0);
	
	@Column(name= "roomType")
	private String roomType;
	
	@Column(name="roomAvailable")
	private	boolean roomAvailable;
	
	@Column(name="price")
	private long price;
	
	 
	//Used for id generation 
	@PrePersist
	public void prePersist() {
		int count;
		try {
		count = roomCount.getCount() + 1;
		}
		catch(NullPointerException e) {
			count=0+1;
		}
	    roomCount.setCount(count);
	    this.roomId = hotel.getHotelId() * 1000L + count;
	}

	public Room(int roomId, Hotel hotel, String roomType, boolean roomAvailable, long price) {
		super();
		this.roomId = roomId;
		this.hotel = hotel;
		this.roomType = roomType;
		this.roomAvailable = roomAvailable;
		this.price = price;
	}
	
	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public Hotel getHotel() {
		return hotel;
	}

public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	

	public boolean isRoomAvailable() {
		return roomAvailable;
	}

	public void setRoomAvailable(boolean roomAvailable) {
		this.roomAvailable = roomAvailable;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	

	//public RoomCount getRoomCount() {
	//	return roomCount;
	//}

	//public void setRoomCount(RoomCount roomCount) {
	//	this.roomCount = roomCount;
	//}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotel=" +hotel + ", roomType=" + roomType + ", roomAvailable="
				+ roomAvailable + ", price=" + price + "]";
	}

}
