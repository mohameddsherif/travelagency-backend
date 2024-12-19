package com.travelagency.travelagency_backend.service;

import com.travelagency.travelagency_backend.model.Notifications;
import com.travelagency.travelagency_backend.repository.NotificationsRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {

    private final NotificationsRepository notificationRepository;
    private final JavaMailSender javaMailSender; // Inject JavaMailSender for email
    private final SmsService smsService; // Inject SmsService for SMS

    public NotificationsService(NotificationsRepository notificationRepository, JavaMailSender javaMailSender, SmsService smsService) {
        this.notificationRepository = notificationRepository;
        this.javaMailSender = javaMailSender;
        this.smsService = smsService;
    }

    // Add notification to database
    public Notifications addNotification(Notifications notification) {
        return notificationRepository.save(notification);
    }

    // Get notifications for a specific user (queued notifications)
    public List<Notifications> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndStatus(userId, "Queued");
    }

    // Get all notifications
    public List<Notifications> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Mark notification as sent
    public void markNotificationAsSent(Long id) {
        Notifications notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setStatus("Sent");
        notificationRepository.save(notification);
    }

    // Method to send notification based on type
    public void sendNotification(Notifications notification) {
        // Check if notification is email or SMS
        if ("Email".equalsIgnoreCase(notification.getType())) {
            sendEmail(notification);
        } else if ("SMS".equalsIgnoreCase(notification.getType())) {
            sendSms(notification);
        } else {
            throw new IllegalArgumentException("Unsupported notification type");
        }
    }

    // Send email notification
    private void sendEmail(Notifications notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getUser().getEmail()); // Get user's email
        message.setSubject("Notification from Travel Agency");
        message.setText(notification.getContent());

        javaMailSender.send(message); // Send email

        // Mark notification as sent
        notification.setStatus("Sent");
        notificationRepository.save(notification);
    }

    // Send SMS notification
    private void sendSms(Notifications notification) {
        // Mock SMS service - you can integrate Twilio or another SMS service here
        smsService.sendSms(notification.getUser().getPhone(), notification.getContent());

        // Mark notification as sent
        notification.setStatus("Sent");
        notificationRepository.save(notification);
    }
}
