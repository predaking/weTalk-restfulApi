package com.savitar.wetalk.service;

import com.savitar.wetalk.dao.ArticlePictureRepository;
import com.savitar.wetalk.dao.ArticleRepository;
import com.savitar.wetalk.entity.Article;
import com.savitar.wetalk.entity.ArticlePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticlePictureRepository articlePictureRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
    public List<Article> getAllArticles() {
        List<Article> list = articleRepository.findAll();
        list.forEach(article -> {
            List<ArticlePicture> articlePicture = articlePictureRepository.getArticlePictures(article.getId());
            article.setArticlePicture(articlePicture);
        });
        return list;
    }
}
