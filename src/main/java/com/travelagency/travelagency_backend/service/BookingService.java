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

    /**
     * Create a new booking for a room.
     *
     * @param userId The ID of the user making the booking.
     * @param roomId The ID of the room to be booked.
     * @param startDate The start date of the booking.
     * @param endDate The end date of the booking.
     * @return The created Booking object.
     */
    public Booking createBooking(Long userId, Long roomId, LocalDateTime startDate, LocalDateTime endDate) {
        // Validate dates
        if (startDate == null || endDate == null || !endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("Invalid booking dates. End date must be after start date.");
        }

        // Find the room and check availability
        Room room = roomService.findRoomById(roomId);
        if (!room.getAvailability()) {
            throw new RuntimeException("Room is not available for booking.");
        }

        // Find the user and validate existence
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Create the booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setStatus("Confirmed");

        // Update room availability
        roomService.updateRoomAvailability(roomId, false);

        // Save and return the booking
        return bookingRepository.save(booking);
    }

    /**
     * Retrieve all bookings.
     *
     * @return A list of all bookings.
     */
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieve a booking by its ID.
     *
     * @param bookingId The ID of the booking.
     * @return The Booking object.
     */
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
    }

    /**
     * Cancel a booking and make the room available.
     *
     * @param bookingId The ID of the booking to cancel.
     */
    public void cancelBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);

        // Mark the associated room as available
        roomService.updateRoomAvailability(booking.getRoom().getId(), true);

        // Delete the booking
        bookingRepository.deleteById(bookingId);
    }
}
