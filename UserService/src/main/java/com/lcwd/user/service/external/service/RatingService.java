package com.lcwd.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.entities.Rating;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

	@GetMapping("/rating/users/{userId}")
	Rating[] getByUserId(@PathVariable String userId);
}
