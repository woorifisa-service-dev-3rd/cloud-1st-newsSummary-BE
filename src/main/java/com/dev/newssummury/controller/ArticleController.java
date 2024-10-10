package com.dev.newssummury.controller;

import com.dev.newssummury.domain.Article;
import com.dev.newssummury.dto.ResArticle;
import com.dev.newssummury.dto.ResArticleNoContent;
import com.dev.newssummury.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public Page<ResArticleNoContent> getArticle() {
        return articleService.findAllWithNoContent();
    }

    @GetMapping("/summary/{id}")
    public ResArticle getArticle(@PathVariable Long id) {
        Article article = articleService.findArticleById(id);
//        return AIService(article);
        return null;
    }
}
