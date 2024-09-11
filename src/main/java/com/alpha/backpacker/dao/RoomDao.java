package com.alpha.backpacker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.backpacker.entity.Room;
import com.alpha.backpacker.repository.RoomRepository;

@Service
public class RoomDao {

    @Autowired
    RoomRepository roomRepository;

    // Create Room
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    // Retrieve Room by ID
    public Optional<Room> getRoomById(int id) {
        return roomRepository.findById(id);
    }

    // Retrieve All Rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Update Room
    public Room updateRoom(int id, Room updatedRoom) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setType(updatedRoom.getType());
            existingRoom.setPrice(updatedRoom.getPrice());
            existingRoom.setStatus(updatedRoom.getStatus());
            return roomRepository.save(existingRoom);
        } else {
            return null;
        }
    }

    // Delete Room by ID
    public boolean deleteRoomById(int id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            roomRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
