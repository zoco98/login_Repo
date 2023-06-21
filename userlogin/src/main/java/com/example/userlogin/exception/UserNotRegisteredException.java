package com.example.userlogin.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class UserNotRegisteredException extends RuntimeException {
	
	String error = "User not exist,Please proceed to registration";
}
