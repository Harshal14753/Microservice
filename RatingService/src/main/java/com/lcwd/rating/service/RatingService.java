package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entities.Rating;

public interface RatingService {

	// create Rating
	Rating createRating(Rating rating);
	
	// get all ratings
	List<Rating> getAllRating();
	
	// get all ratings by UserId
	List<Rating> getAllRatingByUserId(String userId);
	
	// get all ratings by hotelId
	List<Rating> getAllRatingByHotelId(String hotelId);

}

