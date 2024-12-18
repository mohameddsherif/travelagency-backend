//package com.travelagency.travelagency_backend.repository;
//
//import com.travelagency.travelagency_backend.model.Event;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Repository
//public interface EventRepository extends JpaRepository<Event, Long> {
//
//    // Method for searching events by location and date range with pagination
//    Page<Event> findByLocationAndStartDateBetweenAndEndDateBetween(String location, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
//
//    // Advanced search method for location, date range, price range, and event type
//    List<Event> findByLocationAndStartDateBetweenAndEndDateBetweenAndMinPriceBetweenAndMaxPriceBetweenAndEventType(
//            String location, LocalDateTime startDate, LocalDateTime endDate, Double minPrice, Double maxPrice, String eventType);
//}
