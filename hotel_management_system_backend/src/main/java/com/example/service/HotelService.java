package com.example.service;

import java.util.List;

import com.example.model.Hotel;

public interface HotelService {
	Hotel saveHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(long hotelId);
	Hotel updateHotel(Hotel hotel, long hotelId);
	void deleteHotel(long hotelId);
	List<Hotel> getHotelByName(String hotelName);
}
