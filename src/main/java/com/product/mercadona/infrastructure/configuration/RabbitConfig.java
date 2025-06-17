package com.product.mercadona.infrastructure.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "miColaDos";

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}
