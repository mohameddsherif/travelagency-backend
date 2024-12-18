package com.travelagency.travelagency_backend.service;

import com.travelagency.travelagency_backend.model.Notifications;
import com.travelagency.travelagency_backend.repository.NotificationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {
    private final NotificationsRepository notificationRepository;

    public NotificationsService(NotificationsRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notifications addNotification(Notifications notification) {
        return notificationRepository.save(notification);
    }

    public List<Notifications> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndStatus(userId, "Queued"); // Corrected line
    }

    public List<Notifications> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public void markNotificationAsSent(Long id) {
        Notifications notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setStatus("Sent");
        notificationRepository.save(notification);
    }
}
