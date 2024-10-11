package com.dev.newssummury.service;

import com.dev.newssummury.domain.Article;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generation(Article article) {
        String userInput = "This is a news article with the title: " + article.getTitle() +
                ". The content is: " + article.getContent() +
                ". Please summarize it in three lines in Korean.";
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

}
