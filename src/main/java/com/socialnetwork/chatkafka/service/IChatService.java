package com.socialnetwork.chatkafka.service;

import java.util.concurrent.Flow;

public interface IChatService {
    void sendMessage(String message, int senderId, int receiverId);

    void subscribeToMessages(int senderId, int receiverId, Flow.Subscriber<String> subscriber);
}
