package com.socialnetwork.chatkafka.service.consumer.impl;

import com.socialnetwork.chatkafka.service.consumer.IChatConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Flow;

import static com.socialnetwork.chatkafka.util.ChatUtils.generateUniqueChatId;

@Service
@Slf4j
public class ChatConsumer implements IChatConsumer {
    private Map<String, Flow.Subscriber<String>> subscribers = new ConcurrentHashMap<>();

    @Override
    public void subscribeToMessages(int senderId, int receiverId, Flow.Subscriber<String> subscriber) {
        String uniqueId = generateUniqueChatId(senderId, receiverId);
        subscribers.put(uniqueId, subscriber);
    }

    @KafkaListener(topics = "chat")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) throws IOException {
        log.info("Received msg: {} with key: {}", message, key);
        Flow.Subscriber<String> subscriber = subscribers.get(key);
        if (subscriber != null) {
            subscriber.onNext(message);
        }
    }
}