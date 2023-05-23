package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Hotel;
import com.example.model.Room;
import com.example.repository.RoomRepository;
import com.example.service.HotelService;
import com.example.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private RoomRepository roomRepository;
	@Autowired
	private HotelService hotelService;

	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public Room saveRoom(long hotelId,Room room) {
		// TODO Auto-generated method stub
		Hotel hotel=hotelService.getHotelById(hotelId);
		room.setHotel(hotel);
		return roomRepository.save(room);
	}

	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	@Override
	public Room getRoomById(long roomId) {
		// TODO Auto-generated method stub
		/*
		 * Optional<Room> Room=RoomRepository.findById(id); if(Room.isPresent()) {
		 * return Room.get(); }else throw new ResourceNotFoundException("Room","id",id);
		 */
		return roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
	}

	@Override
	public Room updateRoom(Room Room, long roomId) {
		// TODO Auto-generated method stub
		Room existingRoom = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
		existingRoom.setRoomId(Room.getRoomId());
		existingRoom.setHotel(Room.getHotel());
		existingRoom.setRoomAvailable(Room.isRoomAvailable());
		existingRoom.setRoomType(Room.getRoomType());
		existingRoom.setPrice(Room.getPrice());
		roomRepository.save(existingRoom);
		return existingRoom;
	}

	@Override
	public void deleteRoom(long roomId) {
		// TODO Auto-generated method stub
		roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
		roomRepository.deleteById(roomId);

	}

}
