//package com.travelagency.travelagency_backend.service;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class NotificationsServiceTest {}

//    @InjectMocks
//    private NotificationsService notificationService;  // The service we are testing
//
//    @Mock
//    private NotificationsService mockNotificationService;  // Mocking the NotificationService for testing
//
//    @BeforeEach
//    public void setUp() {
//        // This initializes mocks before each test case
//        mockNotificationService = mock(NotificationsService.class);
//    }
//
//    @Test
//    public void testSendEmailNotification() {
//        // Arrange
//        String email = "test@example.com";
//        String subject = "Booking Confirmation";
//        String message = "Your booking is confirmed!";
//
//        // Act
//        notificationService.sendEmailNotification(email, subject, message);
//
//        // Assert
//        // Verifying that sendEmailNotification method was called with correct parameters
//        verify(mockNotificationService, times(1)).sendEmailNotification(email, subject, message);
//    }
//
//    @Test
//    public void testSendSmsNotification() {
//        // Arrange
//        String phoneNumber = "1234567890";
//        String message = "Your booking is confirmed!";
//
//        // Act
//        notificationService.sendSmsNotification(phoneNumber, message);
//
//        // Assert
//        // Verifying that sendSmsNotification method was called with correct parameters
//        verify(mockNotificationService, times(1)).sendSmsNotification(phoneNumber, message);
//    }
//
//    @Test
//    public void testSendBulkNotification() {
//        // Arrange
//        String[] emails = {"test1@example.com", "test2@example.com"};
//        String subject = "Booking Confirmation";
//        String message = "Your booking is confirmed!";
//
//        // Act
//        notificationService.sendBulkNotification(emails, subject, message);
//
//        // Assert
//        // Verifying that sendEmailNotification method was called for each email in the list
//        for (String email : emails) {
//            verify(mockNotificationService, times(1)).sendEmailNotification(email, subject, message);
//        }
//    }
//}