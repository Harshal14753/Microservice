package com.lcwd.rating.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("user_rating")
public class Rating {

	@Id
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
}
