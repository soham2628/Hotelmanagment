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

import com.example.model.Room;
import com.example.service.RoomService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RoomController {

	private RoomService roomService;

	public RoomController(RoomService roomService) {
		super();
		System.out.println("Roomconstructor");
		this.roomService = roomService;
	}

	// http://localhost:8089/api/rooms
	
	@PostMapping("/rooms/{hotelId}")
	public ResponseEntity<Room> saveRoom(@PathVariable("hotelId")long hotelId,@RequestBody Room room) {
		System.out.println(room);
		return new ResponseEntity<Room>(roomService.saveRoom(hotelId, room), HttpStatus.CREATED);
	}

	// http://localhost:8089/api/rooms
	@GetMapping("/api/rooms")
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}

	// http://localhost:8089/api/rooms/2
	@GetMapping("/api/rooms/{roomId}")
	public ResponseEntity<Room> getRoomById(@PathVariable("roomId") long roomId) {
		return new ResponseEntity<Room>(roomService.getRoomById(roomId), HttpStatus.OK);
	}

	// http://localhost:8089/api/rooms/2
	@PutMapping("/api/rooms/{roomId}")
	public ResponseEntity<Room> updateRoom(@PathVariable("roomId") long roomId, @RequestBody Room room) {
		return new ResponseEntity<Room>(roomService.updateRoom(room, roomId), HttpStatus.OK);
	}

	// http://localhost:8089/api/rooms/6
	@DeleteMapping("/api/rooms/{roomId}")
	public ResponseEntity<String> deleteRoom(@PathVariable("roomId") long roomId) {
		roomService.deleteRoom(roomId);
		return new ResponseEntity<String>("Room deleted successfully", HttpStatus.OK);
	}
}
