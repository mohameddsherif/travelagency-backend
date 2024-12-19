package com.travelagency.travelagency_backend.controller;

import com.travelagency.travelagency_backend.model.Room;
import com.travelagency.travelagency_backend.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        List<Room> rooms = roomService.getAvailableRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long roomId) {
        Room room = roomService.findRoomById(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PatchMapping("/{roomId}/availability")
    public ResponseEntity<Void> updateRoomAvailability(@PathVariable Long roomId, @RequestParam boolean available) {
        roomService.updateRoomAvailability(roomId, available);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
