package com.example.userlogin.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
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
public class UserLoginRequest {
	
	@JsonProperty("userEmailId")
	@NotBlank(message = "Please enter email id")
	private String userEmailId;
	
	@JsonProperty("userPassword")
	@NotBlank(message = "Please enter password")
	private String userPassword;
}
