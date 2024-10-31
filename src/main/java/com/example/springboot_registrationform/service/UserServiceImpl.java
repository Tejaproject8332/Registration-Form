package com.example.springboot_registrationform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot_registrationform.entity.User;
import com.example.springboot_registrationform.repo.UserRepo;

@Service
public  class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public void registerUser(User user) {
		 repo.save(user);
		
	}

	  

	@Override
	public User getByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}



	@Override
	public  void updateUsers(List<User> user) {
		// TODO Auto-generated method stub
		  repo.saveAll(user);
	 
	}





 

}
