package com.travelagency.travelagency_backend.controller;

import com.travelagency.travelagency_backend.model.Notifications;
import com.travelagency.travelagency_backend.service.NotificationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

    private final NotificationsService notificationsService;

    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    // Add a new notification
    @PostMapping
    public ResponseEntity<Notifications> addNotification(@RequestBody Notifications notification) {
        Notifications createdNotification = notificationsService.addNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    // Send a notification (either email or SMS)
    @PostMapping("/send/{id}")
    public ResponseEntity<Void> sendNotification(@PathVariable Long id) {
        Notifications notification = notificationsService.getAllNotifications().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notificationsService.sendNotification(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
