package com.alpha.backpacker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.backpacker.dto.ResponseStructure;
import com.alpha.backpacker.entity.Adminn;
import com.alpha.backpacker.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/addadmin")
	public ResponseEntity<ResponseStructure<Adminn>> addcity(@Valid @RequestBody Adminn adminn, String userrole) {
		return adminService.addAdmin(adminn, userrole);
	}
}
