package com.socialnetwork.chatkafka.service.consumer.impl;

import com.socialnetwork.chatkafka.service.consumer.IChatConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;
import java.util.concurrent.Flow;

public class ChatConsumer implements IChatConsumer {
    Map<>
    @Override
    public void subscribeToMessages(int senderId, Flow.Subscriber<String> subscriber) {

    }

    @KafkaListener(topics = "chat", groupId = "group_id")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.MESSAGE_KEY) int key) throws IOException {
        consumerRecord.
    }
}