package com.example.userlogin.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class NoChangesFoundException extends RuntimeException {
	String error = "User did not changes any fields, please fill changes to update";
}
