package com.socialnetwork.chatkafka;

import com.socialnetwork.chatkafka.app.Chat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatKafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChatKafkaApplication.class, args);
    }

    private Chat chat;

    public ChatKafkaApplication(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void run(String... args) throws Exception {
        chat.startChat();
    }
}
