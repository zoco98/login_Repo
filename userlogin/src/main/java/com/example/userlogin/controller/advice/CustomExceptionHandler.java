package com.example.userlogin.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userlogin.exception.ExistingUserException;
import com.example.userlogin.exception.NoChangesFoundException;
import com.example.userlogin.exception.UserNotRegisteredException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidCredentialException(MethodArgumentNotValidException ex){
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ExistingUserException.class)
	public Map<Integer, String> handleAlreadyRegistered(ExistingUserException ex){
		Map<Integer, String> errorMap = new HashMap<>();
		errorMap.put(ex.hashCode(),ex.getError());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotRegisteredException.class)
	public Map<Integer, String> handleNotRegistered(UserNotRegisteredException ex){
		Map<Integer, String> errorMap = new HashMap<>();
		errorMap.put(ex.hashCode(),ex.getError());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NoChangesFoundException.class)
	public Map<Integer, String> handleDataAccessApiUsage(NoChangesFoundException ex){
		Map<Integer, String> errorMap = new HashMap<>();
		errorMap.put(ex.hashCode(),ex.getError());
		return errorMap;
	}
}
