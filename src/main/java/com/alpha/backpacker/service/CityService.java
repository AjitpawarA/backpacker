package com.alpha.backpacker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.alpha.backpacker.dao.CityDao;
import com.alpha.backpacker.dto.ResponseStructure;
import com.alpha.backpacker.entity.City;

import jakarta.validation.Valid;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public ResponseEntity<ResponseStructure<City>> addCity(@Valid City city, @CookieValue String userrole) {
        ResponseStructure<City> responseStructure = new ResponseStructure<>();
//        
//        if (!userrole.equalsIgnoreCase("ADMIN")) {
//            responseStructure.setStatuscode(HttpStatus.UNAUTHORIZED.value());
//            responseStructure.setMessage("Only admins are allowed to add cities.");
//            responseStructure.setData(null);
//            return new ResponseEntity<>(responseStructure, HttpStatus.UNAUTHORIZED);
//        }

        City savedCity = cityDao.createCity(city);

        responseStructure.setStatuscode(HttpStatus.CREATED.value());
        responseStructure.setMessage("City added successfully.");
        responseStructure.setData(savedCity);

        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }
}
