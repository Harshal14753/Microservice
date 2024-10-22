package com.lcwd.user.service.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
	private Hotel hotel;
}
