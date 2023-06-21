package com.example.userlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

	/*
	 * Project name- E_commerce Application
	 * Author- ZOCOMON
	 * MS name- User Login
	 * Objective- Create new user and fetch existing user
	 * Table- User_DB
	 * 1 MS: login/register  
	 * Technical Design-
		  Registration-
		    1. User give credentials- done
		    2. Check user exists or not- done
		    3. If exist it will throw exception- done
		    4. If not exist create new user- done
		    5. Registration ✅
		  Login-
		    1. User if already exists he will login -done
		    2. Check credentials are correct or not- done
		    3. If correct user will login to basket- done
		    4. If not it will throw exception- done
		    5. Login ✅
		Pending:
		  Retrieve user
		  Update user
		  Delete user
	*/
	
@SpringBootApplication
@ComponentScan(basePackages = "com.example.userlogin")
@EnableJpaRepositories
public class UserloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserloginApplication.class, args);
	}

}
