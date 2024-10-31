package com.example.springboot_registrationform.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot_registrationform.entity.User;

@Service
public interface UserService {
	
	public void registerUser(User user);

	 

	public User getByName(String name);
 


	public  void updateUsers(List<User> user);

}
