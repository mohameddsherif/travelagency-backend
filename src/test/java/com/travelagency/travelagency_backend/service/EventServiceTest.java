//package com.travelagency.travelagency_backend.service;
//
//
//
//import com.travelagency.travelagency_backend.model.Event;
//import com.travelagency.travelagency_backend.repository.EventRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class EventServiceTest {}
//
//    @InjectMocks
//    private EventService eventService;
//
//    @Mock
//    private EventRepository eventRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testAddEvent() {
//        Event event = new Event();
//        event.setLocation("Cairo");
//        event.setDate(LocalDateTime.now());
//
//        when(eventRepository.save(event)).thenReturn(event);
//
//        Event addedEvent = eventService.addEvent(event);
//
//        assertNotNull(addedEvent);
//        assertEquals("Cairo", addedEvent.getLocation());
//        verify(eventRepository, times(1)).save(event);
//    }
//
//    @Test
//    public void testSearchEvents() {
//        // Create some sample events
//        Event event1 = new Event();
//        event1.setLocation("Cairo");
//        event1.setDate(LocalDateTime.now());
//
//        Event event2 = new Event();
//        event2.setLocation("Cairo");
//        event2.setDate(LocalDateTime.now().plusDays(1));
//
//        // Wrap the events in a Page object
//        List<Event> events = List.of(event1, event2);
//        Page<Event> eventPage = new PageImpl<>(events);
//
//        // Mock the repository method to return a Page of events
//        when(eventRepository.findByLocationAndDateBetween(eq("Cairo"), any(LocalDateTime.class), any(LocalDateTime.class), any(Pageable.class)))
//                .thenReturn(eventPage);
//
//        // Call the service method
//        Page<Event> eventsPage = eventService.searchEvents("Cairo", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 0, 10, "date");
//
//        // Verify the result
//        assertNotNull(eventsPage);
//        assertEquals(2, eventsPage.getContent().size()); // Verify that two events are returned
//    }
//}
