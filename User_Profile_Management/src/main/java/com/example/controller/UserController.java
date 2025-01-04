package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ProfileDetail;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User userDetail = userService.addUser(user);
		
		return ResponseEntity.ok(userDetail);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}/profile")
	public ResponseEntity<ProfileDetail> updateProfile(@PathVariable Long id, @RequestBody ProfileDetail profileDetail) {
		Optional<ProfileDetail> profile = userService.updateProfile(id,profileDetail);
		return profile.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
		
}
