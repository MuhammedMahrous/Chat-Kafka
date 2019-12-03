package com.socialnetwork.chatkafka.service.subscriber;

import lombok.Builder;

import java.util.concurrent.Flow;

import static com.socialnetwork.chatkafka.app.Chat.EXIT_STRING;
import static com.socialnetwork.chatkafka.app.Chat.exitChat;

@Builder
public class ChatSubscriber implements Flow.Subscriber<String> {
    private int senderId;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(String item) {
        System.out.println(senderId + " -> " + item);
        if (item.equals(EXIT_STRING))
        {
            exitChat();
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
