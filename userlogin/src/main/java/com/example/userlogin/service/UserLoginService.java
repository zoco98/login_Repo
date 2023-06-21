package com.example.userlogin.service;

import org.springframework.stereotype.Service;

import com.example.userlogin.dto.request.UserLoginRequest;
import com.example.userlogin.dto.request.UserRegistrationRequest;
import com.example.userlogin.entities.UserEntity;

@Service
public interface UserLoginService {
	
	//creates new user 
	public UserEntity createUser(UserRegistrationRequest userRegistrationRequest);
	
	//fetches existing user
	public UserEntity fetchUser(UserLoginRequest userLoginRequest);

	//fetches existing user by email id
	public UserEntity fetchUserByEmailID(String emailID);

	//update existing user by email id
	public UserEntity updateUser(UserRegistrationRequest userUpdateRequest, String oldEmailId);
}
