package com.example.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userlogin.dto.request.UserLoginRequest;
import com.example.userlogin.dto.request.UserRegistrationRequest;
import com.example.userlogin.entities.UserEntity;
import com.example.userlogin.service.UserLoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ecommerce/api/user")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	//api to register new user
	@PostMapping("/register")
	public UserEntity registerNewUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
			return userLoginService.createUser(userRegistrationRequest);
	}
	
	//api to login existing user
	@PostMapping("/login")
	public UserEntity loginExistingUser(@RequestBody @Valid UserLoginRequest userLoginRequest) {
			return userLoginService.fetchUser(userLoginRequest);
			
	}
	
	//api to retrieve existing user by email id
	@GetMapping("/fetchUser/{emailID}")
	public UserEntity retrieveUser(@PathVariable String emailID) {
			return userLoginService.fetchUserByEmailID(emailID);
				
	}
	
	//api to retrieve existing user by email id
	@PostMapping("/updateUser/{oldEmailId}")
	public UserEntity retrieveUser(@RequestBody @Valid UserRegistrationRequest userUpdateRequest, @PathVariable String oldEmailId) {
			return userLoginService.updateUser(userUpdateRequest, oldEmailId);
					
	}

	
}
