package com.example.userlogin.dto.request;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationRequest {
	
	@JsonProperty("userName")
	@NotNull(message = "User name should not be null")
	@NotBlank(message = "Please enter user name")
	private String userName;
	
	@JsonProperty("userEmailId")
	@Email(message = "invalid email Id")
	@NotBlank(message = "Please enter email id")
	private String userEmailId;
	
	@JsonProperty("userPassword")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", 
	message = "Minimum eight characters, at least one upper case English letter, one lower case English letter, one number and one special character")
	private String userPassword;
	
	@JsonProperty("userAddress")
	@NotNull
	@NotBlank
	private String userAddress;
}
