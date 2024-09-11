package com.alpha.backpacker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.dao.AdminDao;
import com.alpha.backpacker.dto.ResponseStructure;
import com.alpha.backpacker.entity.Adminn;

import jakarta.validation.Valid;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public ResponseEntity<ResponseStructure<Adminn>> addAdmin(@Valid Adminn adminn, String userrole) {
        ResponseStructure<Adminn> responseStructure = new ResponseStructure<>();
        
//        // Check if the user role is "ADMIN"
//        if (!userrole.equalsIgnoreCase("ADMIN")) {
//            responseStructure.setStatuscode(HttpStatus.UNAUTHORIZED.value());
//            responseStructure.setMessage("Only admins are allowed to add new admin users.");
//            responseStructure.setData(null);
//            return new ResponseEntity<>(responseStructure, HttpStatus.UNAUTHORIZED);
//        }
        
        // Save the new admin entity
        Adminn savedAdmin = adminDao.createAdmin(adminn);
        
        responseStructure.setStatuscode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Admin added successfully.");
        responseStructure.setData(savedAdmin);
        
        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }
}
