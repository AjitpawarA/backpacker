package com.alpha.backpacker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.entity.Userr;
import com.alpha.backpacker.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	// Create User
	public Userr createUser(Userr user) {
		return userRepository.save(user);
	}

	// Retrieve User by ID
	public Optional<Userr> getUserById(int id) {
		return userRepository.findById(id);
	}

	// Retrieve All Users
	public List<Userr> getAllUsers() {
		return userRepository.findAll();
	}

	// Update User
	public Userr updateUser(int id, Userr updatedUser) {
		Optional<Userr> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			Userr existingUser = optionalUser.get();
			// Update fields
			existingUser.setName(updatedUser.getName());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setPhone(updatedUser.getPhone());
			existingUser.setAddress(updatedUser.getAddress());
			// Save updated entity
			return userRepository.save(existingUser);
		} else {
			// Handle user not found, return null or throw an exception
			return null; // You could also throw an exception here if preferred.
		}
	}

	// Delete User by ID
	public boolean deleteUserById(int id) {
		Optional<Userr> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			userRepository.deleteById(id);
			return true; // User successfully deleted
		} else {
			return false; // User not found
		}
	}
}
