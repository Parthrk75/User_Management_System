package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class ProfileDetail {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String address;
	    private String phone;
	    private String bio;
	    
	    @OneToOne
	    @JoinColumn(name = "user_id",nullable = false)
	    @JsonIgnore
	    private User user;

		public ProfileDetail() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ProfileDetail(Long id, String address, String phone, String bio, User user) {
			super();
			this.id = id;
			this.address = address;
			this.phone = phone;
			this.bio = bio;
			this.user = user;
		}

		public ProfileDetail(String address, String phone, String bio, User user) {
			super();
			this.address = address;
			this.phone = phone;
			this.bio = bio;
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getBio() {
			return bio;
		}

		public void setBio(String bio) {
			this.bio = bio;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "ProfileDetail [id=" + id + ", address=" + address + ", phone=" + phone + ", bio=" + bio + ", user="
					+ user + "]";
		}
	    
	    
}
