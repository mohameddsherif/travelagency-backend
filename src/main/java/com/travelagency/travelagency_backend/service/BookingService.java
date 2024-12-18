package com.travelagency.travelagency_backend.service;
import com.travelagency.travelagency_backend.model.Booking;
import com.travelagency.travelagency_backend.model.Room;
import com.travelagency.travelagency_backend.model.User;
import com.travelagency.travelagency_backend.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final UserService userService;

    public BookingService(BookingRepository bookingRepository, RoomService roomService, UserService userService) {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
        this.userService = userService;
    }

    public Booking createBookingForRoom(Long userId, Long roomId, LocalDateTime startDate, LocalDateTime endDate) {
        Room room = roomService.findRoomById(roomId);
        if (!room.getAvailability()) {
            throw new RuntimeException("Room is not available for booking");
        }

        User user = userService.findUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setStatus("Confirmed");

        // Update room availability`
        roomService.updateRoomAvailability(roomId, false);

        return bookingRepository.save(booking);
    }
}