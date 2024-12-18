package com.travelagency.travelagency_backend.repository;
import com.travelagency.travelagency_backend.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findByUserIdAndStatus(Long userId, String status);
}