package com.savitar.wetalk.service;

import com.savitar.wetalk.entity.Article;

import java.util.List;

public interface ArticleService {
    Article addArticle(Article article);
    List<Article> getAllArticles();
    void praise(int id, int praiseCount);
}
