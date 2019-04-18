package com.savitar.wetalk.service;

import com.savitar.wetalk.entity.Article;

import java.util.List;

public interface ArticleService {
    Article addArticle(Article article);
    Article addTransmitArticle(Article article);
    List<Article> getAllArticles();
    Article getArticleDetail(int id);
    void praise(int id, int praiseCount);
}
