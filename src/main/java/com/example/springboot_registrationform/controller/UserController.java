package com.example.springboot_registrationform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot_registrationform.entity.User;
import com.example.springboot_registrationform.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String register(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "register";
	}
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user)
	{
		System.out.println(user);
		if(user.getPassword().equals(user.getCpassword())) {
			try {
				service.registerUser(user);
				return "home";
			}
			catch(Exception e) {
				return "error";
			}
			
		}
		return null;
		
	}

	@GetMapping("/get/{name}")
	public ResponseEntity<User> getByName(@PathVariable  String name) {
		 User user=service.getByName(name);
		 if(user != null) {
			 return new ResponseEntity<>(user,HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);		 }
		
	}
	@PutMapping("/update")
	public  void updateUsers(@RequestBody  List<User> user)
	{
	      service.updateUsers(user);
	}
	 

	
}

	


