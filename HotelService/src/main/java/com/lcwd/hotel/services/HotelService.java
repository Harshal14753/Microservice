package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelService {
	
	// create
	Hotel saveHotel(Hotel hotel);
	
	// get All
	List<Hotel> getAllHotel();
	
	// get hotel by hotel id
	Hotel getHotel(String id);

}
