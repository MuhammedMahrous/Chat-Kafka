package com.socialnetwork.chatkafka.service.consumer;

import java.util.concurrent.Flow;

public interface IChatConsumer {
    void subscribeToMessages(int senderId, Flow.Subscriber<String> subscriber);
}
