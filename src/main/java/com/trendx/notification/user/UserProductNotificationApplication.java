package com.trendx.notification.user;

import com.trendx.notification.user.model.ProductPriceChangeMessage;
import com.trendx.notification.user.model.ProductPriceChangePublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserProductNotificationApplication {
    private final ProductPriceChangePublisher publisher;

    public UserProductNotificationApplication(ProductPriceChangePublisher publisher) {
        this.publisher = publisher;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserProductNotificationApplication.class, args);
    }

    @GetMapping
    public void publish(ProductPriceChangeMessage message) {
        publisher.sendNotification(message);
    }
}
