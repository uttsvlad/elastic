package com.example.elastic.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Vlad Utts
 */
@Data
@Document(indexName = "author")
public class Author {
    private String name;
    private String surname;
}
