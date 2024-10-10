package com.dev.newssummury.controller;

import com.dev.newssummury.service.ArticleService;
import com.dev.newssummury.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class InitController {

    private final ParserService parserService;
    private final ArticleService articleService;

    @GetMapping("/parser")
    public String parser() throws IOException {
        parserService.parseContentFromUrl("test");
        return "Hello World";
    }

    @GetMapping("/getArticle")
    public String getTestArticle() {
        return articleService.getArticleOnlyTitle();
    }
}
