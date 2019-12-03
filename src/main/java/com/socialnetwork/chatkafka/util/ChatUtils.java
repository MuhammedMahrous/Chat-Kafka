package com.socialnetwork.chatkafka.util;

public class ChatUtils {
    public static String generateUniqueChatId(int sender, int receiver) {
        return new StringBuilder().append(sender).append(receiver).toString();
    }
}
