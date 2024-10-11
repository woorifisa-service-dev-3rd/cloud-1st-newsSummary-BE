package com.dev.newssummury.service;

import com.dev.newssummury.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.*;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Slf4j
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
        log.info("입력값: "+userInput);
        CallResponseSpec callResponseSpec= this.chatClient.prompt()
                .user(userInput)
                .call();
        ChatResponse response = callResponseSpec.chatResponse();
        log.info("리스폰스"+response.toString());
        String content= callResponseSpec.content();
        log.info("컨텐츠"+content);

        return content;
    }
}
