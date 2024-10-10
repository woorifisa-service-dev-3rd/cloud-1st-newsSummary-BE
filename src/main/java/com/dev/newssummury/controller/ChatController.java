package com.dev.newssummury.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/call")
    public String generation(@RequestParam String title, @RequestParam String category, @RequestParam String content) {
        String userInput = "This is a news article with the title: " + title +
                ". The category is: " + category +
                ". The content is: " + content +
                ". Please summarize it with more emphasis on categories, but in three lines in Korean.";
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

}
