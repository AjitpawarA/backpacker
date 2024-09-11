package com.alpha.backpacker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.entity.Hotel;
import com.alpha.backpacker.repository.HotelRepository;

@Service
public class HotelDao {

    @Autowired
    HotelRepository hotelRepository;

    // Create Hotel
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Retrieve Hotel by ID
    public Optional<Hotel> getHotelById(int id) {
        return hotelRepository.findById(id);
    }

    // Retrieve All Hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Update Hotel
    public Hotel updateHotel(int id, Hotel updatedHotel) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();
            existingHotel.setName(updatedHotel.getName());
            existingHotel.setEmail(updatedHotel.getEmail());
            existingHotel.setAddress(updatedHotel.getAddress());
            existingHotel.setPhone(updatedHotel.getPhone());
            return hotelRepository.save(existingHotel);
        } else {
            return null;
        }
    }

    // Delete Hotel by ID
    public boolean deleteHotelById(int id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            hotelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
