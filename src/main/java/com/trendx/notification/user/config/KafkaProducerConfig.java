package com.trendx.notification.user.config;

import com.trendx.notification.user.model.ErrorMessage;
import com.trendx.notification.user.model.Notification;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private static final String bootstrapAddress = "localhost:9092";

    @Bean
    public <T> ProducerFactory<String, T> producerFactory(Class<T> valueClass) {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueClass);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Notification> notificationChannel() {
        return new KafkaTemplate<>(producerFactory(Notification.class));
    }

    @Bean
    public KafkaTemplate<String, ErrorMessage> errorChannel() {
        return new KafkaTemplate<>(producerFactory(ErrorMessage.class));
    }
}
