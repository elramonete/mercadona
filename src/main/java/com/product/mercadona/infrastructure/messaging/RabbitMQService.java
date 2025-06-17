package com.product.mercadona.infrastructure.messaging;


import com.product.mercadona.infrastructure.configuration.RabbitConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class RabbitMQService {
    private final RabbitTemplate rabbitTemplate;
    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public Optional<String> enviarMensaje(String message) {
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
            return Optional.of(message);
        } catch (AmqpException amqpException) {
            // Manejo específico de errores de RabbitMQ
            System.err.println("Error al enviar el mensaje a RabbitMQ: " + amqpException.getMessage());
            return Optional.empty();
        }
    }
}