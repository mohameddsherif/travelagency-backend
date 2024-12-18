//package com.travelagency.travelagency_backend.service;
//
//import com.travelagency.travelagency_backend.model.Room;
//import com.travelagency.travelagency_backend.model.SingleRoom;
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
//public class RoomServiceTest {
//
//    @InjectMocks
//    private RoomService roomService;
//
//    @Mock
//    private RoomRepository roomRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetRoomsByHotel() {
//        Room room1 = new SingleRoom();
//        Room room2 = new SingleRoom();
//        when(roomRepository.findByHotelId(1L)).thenReturn(java.util.List.of(room1, room2));
//
//        var rooms = roomService.getRoomsByHotel(1L);
//
//        assertNotNull(rooms);
//        assertEquals(2, rooms.size());
//    }
//
//    @Test
//    public void testUpdateRoomAvailability() {
//        Room room = new SingleRoom();
//        room.setId(1L);
//        room.setAvailability(true);
//
//        when(roomRepository.findById(1L)).thenReturn(java.util.Optional.of(room));
//        when(roomRepository.save(room)).thenReturn(room);
//
//        roomService.updateRoomAvailability(1L, false);
//
//        assertFalse(room.getAvailability());
//        verify(roomRepository, times(1)).save(room);
//    }
//}
