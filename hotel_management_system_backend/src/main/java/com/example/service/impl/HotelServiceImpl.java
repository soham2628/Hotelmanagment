package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Hotel;
import com.example.repository.HotelRepository;
import com.example.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
private HotelRepository hotelRepository;
	
	
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}



	@Override
	public Hotel saveHotel(Hotel Hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(Hotel);
	}



	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}



	@Override
	public Hotel getHotelById(long hotelId) {
		// TODO Auto-generated method stub
		/*
		 * Optional<Hotel> Hotel=HotelRepository.findById(id);
		 * if(Hotel.isPresent()) { return Hotel.get(); }else throw new
		 * ResourceNotFoundException("Hotel","id",id);
		 */
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel","hotelId",hotelId));
	}



	@Override
	public Hotel updateHotel(Hotel Hotel, long hotelId) {
		// TODO Auto-generated method stub
		Hotel existingHotel=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel","hotelId",hotelId));
		existingHotel.setHotelName(Hotel.getHotelName());
		existingHotel.setAddress(Hotel.getAddress());
		existingHotel.setNumberOfRooms(Hotel.getNumberOfRooms());
		existingHotel.setPrice(Hotel.getPrice());
		hotelRepository.save(existingHotel);
		return existingHotel;
	}



	@Override
	public void deleteHotel(long hotelId) {
		// TODO Auto-generated method stub
		hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel","hotelId",hotelId));
		hotelRepository.deleteById(hotelId);
		
	}



	@Override
	public List<Hotel> getHotelByName(String hotelName) {
		// TODO Auto-generated method stub
		return hotelRepository.findByHotelName(hotelName);
	}
	
}

