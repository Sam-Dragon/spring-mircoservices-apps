package com.learning.microservices.users.notifications;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "notification.email.enabled", havingValue = "true")
public class EmailNotification implements NotificationService {

    public void notifyUser() {
        System.out.println("Notification sent successfully");
    }
}
