package com.trendx.notification.user.model;

public interface ProductPriceChangePublisher {
    void sendNotification(ProductPriceChangeMessage message);
}
