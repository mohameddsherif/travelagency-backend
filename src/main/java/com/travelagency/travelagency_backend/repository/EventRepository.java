package com.travelagency.travelagency_backend.repository;

import com.travelagency.travelagency_backend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByLocation(String location);
    List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
