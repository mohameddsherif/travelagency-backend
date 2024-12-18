//package com.travelagency.travelagency_backend.service;
//
//import com.travelagency.travelagency_backend.model.Event;
//import com.travelagency.travelagency_backend.repository.EventRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class EventService {
//
//    private final EventRepository eventRepository;
//
//    // Constructor for dependency injection of EventRepository
//    public EventService(EventRepository eventRepository) {
//        this.eventRepository = eventRepository;
//    }
//
//    // Method for adding a new event to the database
//    public Event addEvent(Event event) {
//        return eventRepository.save(event);  // Saves the event to the repository
//    }
//
//    // Method for searching events by location and date range with pagination
//    public Page<Event> searchEvents(String location, LocalDateTime startDate, LocalDateTime endDate, int page, int size, String sortBy) {
//        Pageable pageable = PageRequest.of(page, size);  // Create Pageable object for pagination
//        return eventRepository.findByLocationAndStartDateBetweenAndEndDateBetween(location, startDate, endDate, pageable);
//    }
//
//    // Advanced search method for location, date range, price range, and event type
//    public List<Event> advancedSearchEvents(String location, LocalDateTime startDate, LocalDateTime endDate, Double minPrice, Double maxPrice, String eventType) {
//        return eventRepository.findByLocationAndStartDateBetweenAndEndDateBetweenAndMinPriceBetweenAndMaxPriceBetweenAndEventType(
//                location, startDate, endDate, minPrice, maxPrice, eventType);
//    }
//
//    // Method to get all events (no pagination)
//    public List<Event> getAllEvents() {
//        return eventRepository.findAll();  // Fetches all events from the repository
//    }
//
//    // Method to find an event by its ID (returns an Optional)
//    public Event findEventById(Long id) {
//        return eventRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Event with id " + id + " not found"));  // Throws exception if not found
//    }
//
//    // Method to find an event by its ID (returns the event directly, throws exception if not found)
//    public Event findEventByIdOrThrow(Long id) {
//        return eventRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Event with id " + id + " not found"));  // Throws exception if not found
//    }
//}
