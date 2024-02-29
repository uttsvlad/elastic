package com.example.elastic.repository;

import com.example.elastic.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vlad Utts
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    List<Article> findByTitle(String title);
    List<Article> findByTitleContaining(String title);

}
