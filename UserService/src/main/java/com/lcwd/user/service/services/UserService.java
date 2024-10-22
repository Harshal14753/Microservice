package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService {

	// create user
	User saveUser(User user);
	
	// get all user
	List<User> getAllUser();
	
	// get user by userId
	User getUser(String userId);
	
	// delete user by userId
	void deleteUser(String userId);
	
	// update user 
	User updateUser(User user);
	
}
