package com.example.elastic.controller;

import com.example.elastic.model.Article;
import com.example.elastic.model.dto.ArticleDto;
import com.example.elastic.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Vlad Utts
 */
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleDto articleDto) {
        return ResponseEntity.ok(articleService.saveIndex(modelMapper.map(articleDto, Article.class)));
    }

    @GetMapping("/findByTitle")
    public ResponseEntity<List<Article>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(articleService.findByTitle(title));
    }

    @GetMapping("/findByTitleContaining")
    public ResponseEntity<List<Article>> findByTitleContaining(@RequestParam String title) {
        return ResponseEntity.ok(articleService.findByTitleContaining(title));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String id) {
        articleService.delete(id);
        return ResponseEntity.ok("DELETED");
    }

    @PostMapping("/update")
    public ResponseEntity<Article> update(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.update(article));
    }
}
