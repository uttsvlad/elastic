package com.example.elastic.service;

import com.example.elastic.model.Article;
import com.example.elastic.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Vlad Utts
 */
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article saveIndex(Article article) {
        article.setId(String.valueOf(UUID.randomUUID()));
        return articleRepository.save(article);
    }

    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    public List<Article> findByTitleContaining(String title) {
        return articleRepository.findByTitleContaining(title);
    }

    public void delete(String id) {
        Optional<Article> byId = articleRepository.findById(id);
        byId.ifPresent(articleRepository::delete);
    }

    public Article update(Article newArticle) {
        Optional<Article> byId = articleRepository.findById(newArticle.getId());
        if (byId.isPresent()) {
            newArticle.setId(byId.get().getId());
            return articleRepository.save(newArticle);
        }
        return null;
    }
}
