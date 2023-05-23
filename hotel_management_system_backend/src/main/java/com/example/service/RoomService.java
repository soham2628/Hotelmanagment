package com.example.service;

import java.util.List;

import com.example.model.Room;

public interface RoomService {
	Room saveRoom(long hotelId,Room room);
	List<Room> getAllRooms();
	Room getRoomById(long reservationId);
	Room updateRoom(Room room, long reservationId);
	void deleteRoom(long reservationId);
}
