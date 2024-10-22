package com.lcwd.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	// create 
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
	}
	
	// get 
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return ResponseEntity.ok(hotelService.getHotel(hotelId));
	}
	
	// get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHostel(){
		return ResponseEntity.ok(hotelService.getAllHotel());
	}
	
}
