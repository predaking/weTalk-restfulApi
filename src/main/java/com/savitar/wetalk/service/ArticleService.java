package com.savitar.wetalk.service;

import com.savitar.wetalk.entity.Article;
import com.savitar.wetalk.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    Article addArticle(Article article);
    Article addTransmitArticle(Article article);
    Page<Article> getAllArticles(Pageable pageable);
    Article getArticleDetail(int id, Pageable pageable);
    void praise(int id, int praiseCount);
}
