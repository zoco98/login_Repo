package com.example.userlogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.userlogin.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	
	@Query(value="SELECT * FROM user userdb WHERE userdb.user_email_id=:emailId AND userdb.user_password=:password",nativeQuery = true)
	UserEntity findByEmailAndPassword(@Param("emailId") String emailId, @Param("password") String password);

	@Query(value="SELECT * FROM user userdb WHERE userdb.user_email_id=:emailId",nativeQuery = true)
	UserEntity findByEmailId(String emailId);

}
