package com.lcwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.service.HotelService;
import com.lcwd.user.service.external.service.RatingService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	// private Logger logger= (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
//		Generate unique user id all the time
		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		// get user from database with the help of user repository
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !!" + userId));
	
		// fetch rating of the above user from USER SERVICE
		// http://localhost:8083/rating/users/userId
//		Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/rating/users/"+user.getUserId(), Rating[].class);
		
		Rating[] ratingOfUser = ratingService.getByUserId(userId);
		
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			// api call to hotel service to get the hotel
			
		 	// ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			// Hotel hotel = entity.getBody();
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		user.setRating(ratingList);
		return user;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User user) {
        // Find existing user by ID
        User user1 = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + user.getUserId()));

        // Update user details
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout()); 

        // Save updated user back to the database
        return userRepository.save(user1);
    }

}
