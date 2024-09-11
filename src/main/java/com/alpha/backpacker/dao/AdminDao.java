package com.alpha.backpacker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.entity.Adminn;
import com.alpha.backpacker.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;

	// Create Admin
	public Adminn createAdmin(Adminn admin) {
		return adminRepository.save(admin);
	}

	// Retrieve Admin by ID
	public Optional<Adminn> getAdminById(int id) {
		return adminRepository.findById(id);
	}

	// Retrieve All Admins
	public List<Adminn> getAllAdmins() {
		return adminRepository.findAll();
	}

	// Update Admin
	public Adminn updateAdmin(int id, Adminn updatedAdmin) {
		Optional<Adminn> optionalAdmin = adminRepository.findById(id);
		if (optionalAdmin.isPresent()) {
			Adminn existingAdmin = optionalAdmin.get();
			existingAdmin.setName(updatedAdmin.getName());
			existingAdmin.setEmail(updatedAdmin.getEmail());
			existingAdmin.setPhone(updatedAdmin.getPhone());
			return adminRepository.save(existingAdmin);
		} else {
			return null;
		}
	}

	// Delete Admin by ID
	public boolean deleteAdminById(int id) {
		Optional<Adminn> optionalAdmin = adminRepository.findById(id);
		if (optionalAdmin.isPresent()) {
			adminRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
