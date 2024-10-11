package com.dev.newssummury.service;

import com.dev.newssummury.domain.Article;
import com.dev.newssummury.dto.ResArticleNoContent;
import com.dev.newssummury.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public String getArticleOnlyTitle() {
        String articleTitle = articleRepository.findTitleById(1L);
        log.info("articleTitle = " + articleTitle);

        return articleRepository.findTitleById(1L);
    }

    public Article findArticleById(Long id) {
        Article article= articleRepository.findById(id)
                .orElseThrow(() -> {log.info("엔티티 없어유");
                    return new RuntimeException("Article not found");
                } );

        return article;
    }

    public Page<ResArticleNoContent> findAllWithNoContent() {
        Pageable pageable = PageRequest
                .of(0, 10, Sort.by(Sort.Order.desc("id")));
        Page<ResArticleNoContent> page = articleRepository.findAllWithNoContent(pageable);
        log.info("page = " + page.getContent());
        return page;
    }
}
