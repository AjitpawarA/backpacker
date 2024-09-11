package com.alpha.backpacker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.entity.Booking;
import com.alpha.backpacker.repository.BookingRepository;

@Service
public class BookingDao {

    @Autowired
    BookingRepository bookingRepository;

    // Create Booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Retrieve Booking by ID
    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    // Retrieve All Bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Update Booking
    public Booking updateBooking(int id, Booking updatedBooking) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();
            existingBooking.setCheckinDate(updatedBooking.getCheckinDate());
            existingBooking.setCheckoutDate(updatedBooking.getCheckoutDate());
            return bookingRepository.save(existingBooking);
        } else {
            return null;
        }
    }

    // Delete Booking by ID
    public boolean deleteBookingById(int id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
