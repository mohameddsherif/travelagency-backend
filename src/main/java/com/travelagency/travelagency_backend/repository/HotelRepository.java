package com.travelagency.travelagency_backend.repository;


import com.travelagency.travelagency_backend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocationAndType(String location, String type);
}