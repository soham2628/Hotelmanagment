package com.example.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

	 List<Hotel> findByHotelName(String hotelName);

}
