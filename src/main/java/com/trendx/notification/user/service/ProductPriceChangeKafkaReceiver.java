package com.trendx.notification.user.service;

import com.trendx.notification.user.model.*;
import org.springframework.kafka.annotation.KafkaListener;

public class ProductPriceChangeKafkaReceiver implements ProductPriceChangeListener {
    private final ProductPriceChangePublisher publisher;

    public ProductPriceChangeKafkaReceiver(ProductPriceChangePublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    @KafkaListener(topics = "product.up.price", groupId = "test")
    public void receive(ProductPriceChangeMessage message) {
        publisher.sendNotification(message);
    }
}
