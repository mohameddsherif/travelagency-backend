package com.travelagency.travelagency_backend.service;

import com.travelagency.travelagency_backend.model.Hotel;
import com.travelagency.travelagency_backend.model.Room;
import com.travelagency.travelagency_backend.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final RoomService roomService;

    public HotelService(HotelRepository hotelRepository, RoomService roomService) {
        this.hotelRepository = hotelRepository;
        this.roomService = roomService;
    }

    /**
     * Add a new hotel to the database.
     *
     * @param hotel The Hotel object to be added.
     * @return The saved Hotel object.
     */
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Retrieve all hotels from the database.
     *
     * @return A list of all hotels.
     */
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    /**
     * Retrieve a specific hotel by its ID.
     *
     * @param hotelId The ID of the hotel.
     * @return An Optional containing the Hotel if found.
     */
    public Optional<Hotel> findHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    /**
     * Get all rooms for a specific hotel.
     *
     * @param hotelId The ID of the hotel.
     * @return A list of rooms associated with the hotel.
     */
    public List<Room> getRoomsForHotel(Long hotelId) {
        return roomService.getRoomsByHotel(hotelId);
    }

    /**
     * Add a room to a specific hotel.
     *
     * @param hotelId The ID of the hotel.
     * @param room    The Room object to be added.
     * @return The saved Room object.
     */
    public Room addRoomToHotel(Long hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));
        room.setHotel(hotel);
        return roomService.addRoom(room);
    }
}
