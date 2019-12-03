package com.socialnetwork.chatkafka.app;

import com.socialnetwork.chatkafka.service.subscriber.ChatSubscriber;
import com.socialnetwork.chatkafka.service.IChatService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class Chat {
    private Scanner scanner;
    private IChatService chatService;
    public static String EXIT_STRING = "#&%EXIT_CHAT#&%";

    public Chat(IChatService chatService) {
        this.scanner = new Scanner(System.in);
        this.chatService = chatService;
    }

    @PostConstruct
    public void startChat() {
        System.out.println("please enter you id and your friend id");
        int userId = scanner.nextInt();
        int friendId = scanner.nextInt();
        String input = "";
        chatService.subscribeToMessages(friendId, ChatSubscriber.builder().senderId(friendId).build());
        System.out.println("You can start chatting now");
        do {
            input = scanner.nextLine();
            chatService.sendMessage(input, userId, friendId);
        } while (!input.equals(EXIT_STRING));
        exitChat();
    }

    public static void exitChat() {
        System.out.println("BYE BYE..");
        System.exit(0);
    }
}
