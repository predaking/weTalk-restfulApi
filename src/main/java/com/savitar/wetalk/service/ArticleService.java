package com.savitar.wetalk.service;

import com.savitar.wetalk.entity.Article;
import org.springframework.web.multipart.MultipartFile;

public interface ArticleService {
    Article addArticle(Article article);
    boolean addArticlePicture(int id, MultipartFile file);
}
