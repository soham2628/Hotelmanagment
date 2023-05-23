package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hotel;
import com.example.service.HotelService;

@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
//http://localhost:8089/api/hotels/

public class HotelController {
	
	private HotelService hotelService;

	public HotelController(HotelService HotelService) {
		super();
		this.hotelService = HotelService;
	}
	//http://localhost:8089/api/hotels
	@PostMapping("/api/hotels")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
	{
		return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
	}
	//http://localhost:8089/api/hotels
	@GetMapping("/api/hotels")
	public List<Hotel> getAllHotels()
	{
		return hotelService.getAllHotels();
	}
	//http://localhost:8089/api/hotels/name
	@GetMapping("/hotels/name/{hotelName}")
	public List<Hotel> getHotelByName(@PathVariable("hotelName") String hotelName){
		return hotelService.getHotelByName(hotelName);
	}
	//http://localhost:8089/api/hotels/2
	@GetMapping("/hotels/id/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") long hotelId)
	{
		return new ResponseEntity<Hotel>(hotelService.getHotelById(hotelId),HttpStatus.OK);
	}
	//http://localhost:8089/api/hotels/2
	@PutMapping("/api/hotels/{hotelId}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("hotelId") long hotelId, @RequestBody Hotel hotel)
	{
		return new ResponseEntity<Hotel> (hotelService.updateHotel(hotel, hotelId),HttpStatus.OK);
	}
	//http://localhost:8089/api/hotels/6
	@DeleteMapping("/api/hotels/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable("hotelId") long hotelId)
	{
		hotelService.deleteHotel(hotelId);
		return new ResponseEntity<String>("Hotel deleted successfully",HttpStatus.OK);
	}
}

