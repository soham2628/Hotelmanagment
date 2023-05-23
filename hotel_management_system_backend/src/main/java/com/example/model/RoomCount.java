package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class RoomCount {
	@Id
	private Long hotelId;
	 
	private int count;

	public RoomCount(Long hotelId, int count) {
		super();
		this.hotelId = hotelId;
		this.count = count;
	}
	
	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "RoomCount [hotelId=" + hotelId + ", count=" + count + "]";
	}
}
