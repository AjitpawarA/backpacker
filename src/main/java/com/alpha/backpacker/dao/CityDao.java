package com.alpha.backpacker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.entity.City;
import com.alpha.backpacker.repository.CityRepository;

@Service
public class CityDao {

    @Autowired
    CityRepository cityRepository;

    // Create City
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    // Retrieve City by ID
    public Optional<City> getCityById(int id) {
        return cityRepository.findById(id);
    }

    // Retrieve All Cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Update City
    public City updateCity(int id, City updatedCity) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            City existingCity = optionalCity.get();
            existingCity.setName(updatedCity.getName());
            existingCity.setState(updatedCity.getState());
            existingCity.setCost(updatedCity.getCost());
            return cityRepository.save(existingCity);
        } else {
            return null;
        }
    }

    // Delete City by ID
    public boolean deleteCityById(int id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            cityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
