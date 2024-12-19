package com.travelagency.travelagency_backend.controller;

import com.travelagency.travelagency_backend.model.Booking;
import com.travelagency.travelagency_backend.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Create a new booking.
     *
     * @param userId The ID of the user making the booking.
     * @param roomId The ID of the room to be booked.
     * @param startDate The start date of the booking.
     * @param endDate The end date of the booking.
     * @return The created Booking object.
     */
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestParam Long userId,
                                                 @RequestParam Long roomId,
                                                 @RequestParam LocalDateTime startDate,
                                                 @RequestParam LocalDateTime endDate) {
        Booking createdBooking = bookingService.createBooking(userId, roomId, startDate, endDate);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    /**
     * Retrieve all bookings.
     *
     * @return A list of all bookings.
     */
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    /**
     * Retrieve a specific booking by ID.
     *
     * @param id The ID of the booking.
     * @return The Booking object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Long id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Cancel a booking by ID.
     *
     * @param id The ID of the booking to cancel.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
