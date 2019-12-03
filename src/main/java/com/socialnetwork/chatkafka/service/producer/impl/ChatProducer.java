package com.socialnetwork.chatkafka.service.producer.impl;

import com.socialnetwork.chatkafka.service.producer.IChatProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.socialnetwork.chatkafka.util.ChatUtils.generateUniqueChatId;

@Component
@Slf4j
public class ChatProducer implements IChatProducer {

    private static final String TOPIC = "chat";
    private KafkaTemplate<String, String> kafkaTemplate;

    public ChatProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message, int senderId, int receiverId) {

        String uniqueId = generateUniqueChatId(senderId, receiverId);
        log.info("Will send msg: {} with key: {}", message, uniqueId);
        kafkaTemplate.send(TOPIC, uniqueId, message);
    }


}
