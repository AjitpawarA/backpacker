package com.alpha.backpacker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.backpacker.dao.UserDao;
import com.alpha.backpacker.dto.ResponseStructure;
import com.alpha.backpacker.entity.City;
import com.alpha.backpacker.entity.Userr;
import com.alpha.backpacker.service.CityService;
import com.alpha.backpacker.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CityService cityService;

    @PostMapping("/addUser")
    public ResponseEntity<ResponseStructure<Map<String, Object>>> addUser(@Valid @RequestBody Userr user, String userrole) {
		return userService.addUser(user, userrole);
    }
    
    @PostMapping("/addcity")
    public ResponseEntity<ResponseStructure<City>> addcity(@Valid @RequestBody City city, String userrole) {
		return cityService.addCity(city, userrole);
    }
}
