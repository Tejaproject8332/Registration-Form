package com.example.springboot_registrationform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_registrationform.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByName(String name);

	 

//	User findByName(String name);
//
//	User findByUserName(String username);

}
