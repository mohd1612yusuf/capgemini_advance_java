package com.example.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "recharge.queue";
    public static final String DLQ = "recharge.dlq";

    @Bean
    public Queue rechargeQueue() {

        Map<String, Object> args = new HashMap<>();

        args.put("x-message-ttl", 10000);
        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", DLQ);

        return new Queue(QUEUE_NAME, true, false, false, args);
    }

    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DLQ, true);
    }
}