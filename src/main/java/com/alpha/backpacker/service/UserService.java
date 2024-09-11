package com.alpha.backpacker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.dao.UserDao;
import com.alpha.backpacker.dto.ResponseStructure;
import com.alpha.backpacker.entity.Userr;

import jakarta.validation.Valid;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public ResponseEntity<ResponseStructure<Map<String, Object>>> addUser(@Valid Userr user, String userrole) {
        ResponseStructure<Map<String, Object>> responseStructure = new ResponseStructure<>();
        
        Map<String, Object> data = new HashMap<>();
        
        try {
            Userr savedUser = userDao.createUser(user);
            
            data.put("user", savedUser);
            
            data.put("role", userrole);
            
            responseStructure.setStatuscode(HttpStatus.CREATED.value());
            responseStructure.setMessage("User created successfully.");
            responseStructure.setData(data);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(responseStructure);
        } catch (Exception e) {
            responseStructure.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseStructure.setMessage("Failed to create user. Error: " + e.getMessage());
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseStructure);
        }
    }
}
