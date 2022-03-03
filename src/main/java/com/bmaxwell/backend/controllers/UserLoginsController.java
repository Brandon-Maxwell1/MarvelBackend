package com.bmaxwell.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmaxwell.backend.exceptions.ResourceNotFoundException;
import com.bmaxwell.backend.models.userLogins;
import com.bmaxwell.backend.repositories.UserLoginsRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserLoginsController {

	
	@Autowired
	private UserLoginsRepository userRepo;
	
	@GetMapping("allusers")
	public List<userLogins> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("users/{userid}")
	public ResponseEntity<userLogins> getUserById(@PathVariable int userid) {
		userLogins user = userRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("allusers/{username}")
	public List<userLogins> getUserByUsername(@PathVariable String username) {
		List<userLogins> user = userRepo.findByUsername(username);
		if (user.isEmpty()) {
			System.out.println(new ResourceNotFoundException("User(s) with the name " + username + " not found."));
		}
		return userRepo.findByUsername(username);
	}
	
	@PostMapping("adduser")
	public userLogins newUser(@RequestBody userLogins user) {
		return userRepo.save(user);
	}
	
	@PutMapping("user/{userid}")
	public ResponseEntity<userLogins> updateUser(@PathVariable int userid, @RequestBody userLogins newUserInfo) {
		userLogins foundUser = userRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
		
		foundUser.setUsername(newUserInfo.getUsername());
		
		userLogins updatedUser = userRepo.save(foundUser);
		
		return ResponseEntity.ok(updatedUser);
	}
	
//	@DeleteMapping("user/{userid}")
//	public ResponseEntity<String> deleteUser(@PathVariable int userid) {
//		userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
//		
//		String message = "User has been deleted.";
//		
//		userRepo.deleteById(userid);
//		return new ResponseEntity<>(message, HttpStatus.OK);
//	}
		
}
