package com.socialnetwork.chatkafka.service.producer;

public interface IChatProducer {
    void sendMessage(String message, int senderId, int receiverId);
}
