package org.example.steamnotificationservice.repository;


import org.example.steamnotificationservice.entity.Notification;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends ReactiveCrudRepository<Notification, String> {
    Flux<Notification> findByUserIdAndReadFalse(Long userId);
}
