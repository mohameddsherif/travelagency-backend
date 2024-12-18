package com.travelagency.travelagency_backend.service;

import com.travelagency.travelagency_backend.model.Room;
import com.travelagency.travelagency_backend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getRoomsByHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailability(true);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public void updateRoomAvailability(Long roomId, boolean available) {
        Room room = findRoomById(roomId);
        room.setAvailability(available);
        roomRepository.save(room);
    }
}

