package com.travelagency.travelagency_backend.service;

import com.travelagency.travelagency_backend.model.Hotel;
import com.travelagency.travelagency_backend.model.Room;
import com.travelagency.travelagency_backend.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final RoomService roomService;

    public HotelService(HotelRepository hotelRepository, RoomService roomService) {
        this.hotelRepository = hotelRepository;
        this.roomService = roomService;
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Room> getRoomsForHotel(Long hotelId) {
        return roomService.getRoomsByHotel(hotelId);
    }

    public Room addRoomToHotel(Long hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));
        room.setHotel(hotel);
        return roomService.addRoom(room);
    }
}