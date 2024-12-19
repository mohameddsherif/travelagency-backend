package com.travelagency.travelagency_backend.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    // Mock method to simulate sending an SMS
    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
