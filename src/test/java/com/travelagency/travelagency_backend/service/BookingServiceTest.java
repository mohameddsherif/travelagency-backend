//package com.travelagency.travelagency_backend.service;
//import com.travelagency.travelagency_backend.model.Booking;
//import com.travelagency.travelagency_backend.model.Room;
//import com.travelagency.travelagency_backend.model.User;
//import com.travelagency.travelagency_backend.repository.BookingRepository;
//import com.travelagency.travelagency_backend.repository.RoomRepository;
//import com.travelagency.travelagency_backend.repository.UserRepository;
//import com.travelagency.travelagency_backend.model.SingleRoom;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDateTime;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BookingServiceTest {
//
//    @InjectMocks
//    private BookingService bookingService;
//
//    @Mock
//    private BookingRepository bookingRepository;
//    @Mock
//    private RoomRepository roomRepository;
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testCreateBooking() {
//        // Given
//        User user = new User();
//        user.setId(1L);
//
//        // Use a concrete subclass of Room (e.g., SingleRoom)
//        Room room = new SingleRoom(); // Instantiate a concrete subclass of Room
//        room.setId(1L);
//        room.setAvailability(true);
//
//        Booking booking = new Booking();
//        booking.setUser(user);
//        booking.setRoom(room);
//        booking.setStartDate(LocalDateTime.now());
//        booking.setEndDate(LocalDateTime.now().plusDays(1));
//
//        // When
//        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
//        when(roomRepository.findById(1L)).thenReturn(java.util.Optional.of(room));
//        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
//
//        // Then
//        Booking createdBooking = bookingService.createBookingForRoom(1L, 1L, LocalDateTime.now(), LocalDateTime.now().plusDays(1));
//
//        assertNotNull(createdBooking);
//        assertEquals(1L, createdBooking.getUser().getId());
//        assertEquals(1L, createdBooking.getRoom().getId());
//        verify(roomRepository, times(1)).save(any(Room.class));  // Verify room availability was updated
//    }
//}