package com.socialnetwork.chatkafka.service.impl;

import com.socialnetwork.chatkafka.service.IChatService;
import com.socialnetwork.chatkafka.service.consumer.IChatConsumer;
import com.socialnetwork.chatkafka.service.producer.IChatProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Flow;

@Service
@AllArgsConstructor
public class ChatService implements IChatService {
    private IChatConsumer consumer;
    private IChatProducer producer;

    @Override
    public void sendMessage(String message, int senderId, int receiverId) {
        producer.sendMessage(message, senderId, receiverId);
    }

    @Override
    public void subscribeToMessages(int senderId, int receiverId, Flow.Subscriber<String> subscriber) {
        consumer.subscribeToMessages(senderId,receiverId, subscriber);
    }
}
