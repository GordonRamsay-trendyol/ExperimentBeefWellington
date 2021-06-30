package com.trendx.notification.user.service;

import com.trendx.notification.user.model.*;
import com.trendx.notification.user.service.ex.ProductNotFound;
import com.trendx.notification.user.service.ex.PublishProcessFailed;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPriceChangeKafkaPublisher implements ProductPriceChangePublisher {
    private final KafkaTemplate<String, Notification> notificationChannel;
    private final KafkaTemplate<String, ErrorMessage> errorChannel;

    private static final String notificationTopic = "notification.product.change";
    private static final String errorTopic = "error.notification.product.change";

    public ProductPriceChangeKafkaPublisher(KafkaTemplate<String, Notification> notificationChannel,
                                            KafkaTemplate<String, ErrorMessage> errorChannel) {
        this.notificationChannel = notificationChannel;
        this.errorChannel = errorChannel;
    }

    @Override
    public void sendNotification(ProductPriceChangeMessage message) {
        try {
            sendNotificationMsg(message);
        } catch (PublishProcessFailed e) {
            sendErrorMsg(e.getErrorMessage());
        }
    }

    private void sendNotificationMsg(ProductPriceChangeMessage message) throws PublishProcessFailed {
        Optional<Product> optionalProduct = findProduct(message.getProductId());

        Product product = optionalProduct.orElseThrow(ProductNotFound::new);
        List<User> followers = product.getFollowers();

        followers.parallelStream().forEach(follower -> {
            Notification notification = Notification.from(follower, message);
            notificationChannel.send(notificationTopic, notification);
        });
    }

    private Optional<Product> findProduct(Long productId) {
        return Optional.empty();
    }

    private void sendErrorMsg(ErrorMessage errorMsg) {
        errorChannel.send(errorTopic, errorMsg);
    }

}
