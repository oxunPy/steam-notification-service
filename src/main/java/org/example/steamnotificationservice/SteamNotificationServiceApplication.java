package org.example.steamnotificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SteamNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteamNotificationServiceApplication.class, args);
    }

}
