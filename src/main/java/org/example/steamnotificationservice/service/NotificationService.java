package org.example.steamnotificationservice.service;

import org.example.steamnotificationservice.entity.Notification;
import org.example.steamnotificationservice.repository.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @KafkaListener(topics = {"${kafka.topic.request.notification}"}, groupId = "${kafka.topic.request.group}")
    public void listenMatchmakingNotifications(String message) {
        Notification notification = new Notification();
        notification.setUserId("1");
        notification.setMessage(message);
        notification.setRead(false);
        notification.setTimestamp(LocalDateTime.now());

        notificationRepository.save(notification).subscribe();
    }
}
