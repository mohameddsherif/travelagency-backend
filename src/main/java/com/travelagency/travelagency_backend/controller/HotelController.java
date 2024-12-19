package com.travelagency.travelagency_backend.controller;

import com.travelagency.travelagency_backend.model.Hotel;
import com.travelagency.travelagency_backend.model.Room;
import com.travelagency.travelagency_backend.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService   .getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PostMapping("/{hotelId}/rooms")
    public ResponseEntity<Room> addRoomToHotel(@PathVariable Long hotelId, @RequestBody Room room) {
        Room createdRoom = hotelService.addRoomToHotel(hotelId, room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}/rooms")
    public ResponseEntity<List<Room>> getRoomsForHotel(@PathVariable Long hotelId) {
        List<Room> rooms = hotelService.getRoomsForHotel(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
