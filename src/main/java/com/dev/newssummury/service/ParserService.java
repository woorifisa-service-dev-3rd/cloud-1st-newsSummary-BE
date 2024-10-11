package com.dev.newssummury.service;

import com.dev.newssummury.domain.Article;
import com.dev.newssummury.domain.ResponseData;
import com.dev.newssummury.repository.ArticleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParserService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void processJson(String jsonData) {
        try {
            // ObjectMapper를 사용하여 JSON을 ApiResponse 객체로 변환
            Gson gson = new Gson();
            ResponseData apiResponse = gson.fromJson(jsonData, ResponseData.class);

            List<Article> articleList =
                    apiResponse.getItems().stream().map(item ->
                            Article.of(replaceHtml(item.getTitle()), replaceHtml(item.getDescription()))
                    ).toList();

            articleRepository.saveAll(articleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String replaceHtml(String html) {
        return html.replaceAll("<[^>]*>", "");
    }

}
