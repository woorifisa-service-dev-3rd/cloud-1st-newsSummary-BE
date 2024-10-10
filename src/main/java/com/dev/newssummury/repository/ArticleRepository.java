package com.dev.newssummury.repository;

import com.dev.newssummury.domain.Article;
import com.dev.newssummury.dto.ResArticleNoContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("select a.title from Article a where a.id=:id")
    String findTitleById(Long id);

    @Query("select new com.dev.newssummury.dto.ResArticleNoContent(a.id,a.title) from Article a")
    Page<ResArticleNoContent> findAllWithNoContent(Pageable pageable);
}
