package org.example.steamnotificationservice.config.kafka.topic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.reply.notification}")
    private String replyNotification;

    @Value("${kafka.topic.request.notification}")
    private String requestNotification;

    @Bean
    public KafkaAdmin.NewTopics requests() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(requestNotification).build());
    }

    @Bean
    public KafkaAdmin.NewTopics replies() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(replyNotification).build());
    }
}
