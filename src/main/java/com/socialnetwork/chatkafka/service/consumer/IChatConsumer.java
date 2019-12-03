package com.socialnetwork.chatkafka.service.consumer;

import java.util.concurrent.Flow;

public interface IChatConsumer {
    void subscribeToMessages(int senderId, int receiverId, Flow.Subscriber<String> subscriber);
}
