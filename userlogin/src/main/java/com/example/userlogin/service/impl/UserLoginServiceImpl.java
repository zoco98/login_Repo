package com.example.userlogin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userlogin.dto.request.UserLoginRequest;
import com.example.userlogin.dto.request.UserRegistrationRequest;
import com.example.userlogin.entities.UserEntity;
import com.example.userlogin.exception.ExistingUserException;
import com.example.userlogin.exception.NoChangesFoundException;
import com.example.userlogin.exception.UserNotRegisteredException;
import com.example.userlogin.repo.UserRepository;
import com.example.userlogin.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserEntity createUser(UserRegistrationRequest userRegistrationRequest) {
		UserEntity user = new UserEntity(0,userRegistrationRequest.getUserName(), userRegistrationRequest.getUserEmailId(),userRegistrationRequest.getUserPassword());
			if(!isExistingUser(user)) {
				return userRepo.save(user);
			}
		throw new ExistingUserException();
	}
	
	@Override
	public UserEntity fetchUser(UserLoginRequest userLoginRequest) {
		UserEntity registerdUser = findUser(userLoginRequest.getUserEmailId(), userLoginRequest.getUserPassword());
		if (registerdUser!=null) {
			return registerdUser;
		} 
		throw new UserNotRegisteredException();
	}
	
	@Override
	public UserEntity fetchUserByEmailID(String emailId) {
		//customized query logic to find user by its email 
		return userRepo.findByEmailId(emailId);
	}
	
	@Override
	public UserEntity updateUser(UserRegistrationRequest userUpdateRequest, String oldEmailId) {
		//customized query logic to find user by its email 
		UserEntity user = userRepo.findByEmailId(oldEmailId);
		return updateUserFields(userUpdateRequest, user);
	}

	/**
	 * @param userUpdateRequest
	 * @param user
	 * Logic to update user with given changes
	 */
	private UserEntity updateUserFields(UserRegistrationRequest userUpdateRequest, UserEntity user) {
			if(user!=null) {
				if(!(user.getUserEmailId().equalsIgnoreCase(userUpdateRequest.getUserEmailId()))) {
					user.setUserEmailId(userUpdateRequest.getUserEmailId());
				}else {
					if(!(user.getUserName().equalsIgnoreCase(userUpdateRequest.getUserName()))){
						user.setUserName(userUpdateRequest.getUserName());
					}else {
						if(!(user.getUserPassword().equalsIgnoreCase(userUpdateRequest.getUserPassword()))) {
							user.setUserPassword(userUpdateRequest.getUserPassword());
						}
						throw new NoChangesFoundException();
					}
				}
				userRepo.save(user);
				return user;
		}
		throw new UserNotRegisteredException();
	}
	
	/**
	 * @param newUser
	 * Logic to check one user is existing or not
	 */
	private boolean isExistingUser(UserEntity newUser) {
		boolean isExUser=false;
		List<UserEntity> existingUsers=fetchAllUser();
		for (UserEntity exUser : existingUsers) {
			if(exUser.getUserEmailId().equalsIgnoreCase(newUser.getUserEmailId())) {
				isExUser=true;
				break;
			}
		}
		return isExUser;
	}

	/**
	 * Logic to get all Users in user repository
	 */
	private List<UserEntity> fetchAllUser() {
		return userRepo.findAll();
	}

	/**
	 * @param emailId
	 * @param password
	 * customized query logic to find user by its email and password during login
	 */
	private UserEntity findUser(String emailId, String password) {
		return userRepo.findByEmailAndPassword(emailId, password);
	}
}
