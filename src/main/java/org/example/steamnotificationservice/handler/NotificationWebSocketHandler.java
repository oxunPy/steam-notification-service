package org.example.steamnotificationservice.handler;

import org.example.steamnotificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.socket.WebSocketSession;

import java.time.Duration;

@Component
public class NotificationWebSocketHandler implements WebSocketHandler {

    private final NotificationRepository notificationRepository;

    public NotificationWebSocketHandler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<String> notifications = Flux.interval(Duration.ofSeconds(5))
                .flatMap(tick -> notificationRepository.findByUserIdAndReadFalse(1L))
                .map(notification -> "New Notification: " + notification.getMessage());

        return session.send(notifications.map(session::textMessage));
    }
}
