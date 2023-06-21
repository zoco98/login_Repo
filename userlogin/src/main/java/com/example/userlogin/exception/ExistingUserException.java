package com.example.userlogin.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ExistingUserException extends RuntimeException{

	String error = "User already exist,Please proceed to login";
}
