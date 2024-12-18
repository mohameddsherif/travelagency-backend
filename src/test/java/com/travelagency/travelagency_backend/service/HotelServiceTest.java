//package com.travelagency.travelagency_backend.service;
//import com.travelagency.travelagency_backend.model.Hotel;
//import com.travelagency.travelagency_backend.model.Room;
//import com.travelagency.travelagency_backend.model.SingleRoom;
//import com.travelagency.travelagency_backend.repository.HotelRepository;
//import com.travelagency.travelagency_backend.repository.RoomRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class HotelServiceTest {
//
//    @InjectMocks
//    private HotelService hotelService;
//
//    @Mock
//    private HotelRepository hotelRepository;
//    @Mock
//    private RoomRepository roomRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testAddRoomToHotel() {
//        Hotel hotel = new Hotel();
//        hotel.setId(1L);
//
//        Room room = new SingleRoom();
//        room.setHotel(hotel);
//
//        when(hotelRepository.findById(1L)).thenReturn(java.util.Optional.of(hotel));
//        when(roomRepository.save(room)).thenReturn(room);
//
//        Room addedRoom = hotelService.addRoomToHotel(1L, room);
//
//        assertNotNull(addedRoom);
//        assertEquals(1L, addedRoom.getHotel().getId());
//        verify(roomRepository, times(1)).save(room);
//    }
//
//    @Test
//    public void testGetRoomsForHotel() {
//        Hotel hotel = new Hotel();
//        hotel.setId(1L);
//
//        Room room1 = new SingleRoom();
//        room1.setHotel(hotel);
//
//        Room room2 = new SingleRoom();
//        room2.setHotel(hotel);
//
//        when(roomRepository.findByHotelId(1L)).thenReturn(java.util.List.of(room1, room2));
//
//        var rooms = hotelService.getRoomsForHotel(1L);
//
//        assertNotNull(rooms);
//        assertEquals(2, rooms.size());
//    }
//}
