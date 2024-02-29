package com.example.elastic.model.dto;

import com.example.elastic.model.Author;
import lombok.Data;

import java.util.List;

/**
 * @author Vlad Utts
 */
@Data
public class ArticleDto {

    private String title;

    private List<Author> authors;
}
