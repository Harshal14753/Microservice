package com.lcwd.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.service.RatingService;
import com.lcwd.rating.service.impl.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	// create
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	// get all
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	// get all by userId
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllByUserId(@PathVariable String userId){
		
		List<Rating> rating = ratingService.getAllRatingByUserId(userId);
		
		if (rating == null || rating.isEmpty()) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.ok(rating);
	}
	
	// get all by hotelI
	@GetMapping("/hotels/{hotelId}")
		public ResponseEntity<List<Rating>> getAllByhotelId(@PathVariable String hotelId){
			return ResponseEntity.ok(ratingService.getAllRatingByHotelId(hotelId));
		}
	
}












