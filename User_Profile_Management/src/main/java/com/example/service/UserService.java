package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.ProfileDetail;
import com.example.entity.User;
import com.example.repository.ProfileDetailRepository;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileDetailRepository profileDetailRepository;

	public User addUser(User user) {
		ProfileDetail profileDetail = new ProfileDetail();
		profileDetail.setUser(user);
		user.setProfileDetail(profileDetail);
		return userRepository.save(user);
	}

	

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}



	public Optional<ProfileDetail> updateProfile(Long id, ProfileDetail updatedProfileDetail) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			ProfileDetail profileDetail = user.get().getProfileDetail();
			profileDetail.setAddress(updatedProfileDetail.getAddress());
			profileDetail.setPhone(updatedProfileDetail.getPhone());
			profileDetail.setBio(updatedProfileDetail.getBio());
			return Optional.of(profileDetailRepository.save(profileDetail));
		}
		return Optional.empty();
		
		
		
	}



	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}
	
	
}
