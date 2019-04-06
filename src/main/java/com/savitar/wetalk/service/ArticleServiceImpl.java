package com.savitar.wetalk.service;

import com.savitar.wetalk.dao.ArticlePictureRepository;
import com.savitar.wetalk.dao.ArticleRepository;
import com.savitar.wetalk.entity.Article;
import com.savitar.wetalk.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

//    @Autowired
//    private ArticlePictureRepository articlePictureRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public boolean addArticlePicture(int id, MultipartFile file) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\weTalkImages\\";
        System.out.println(fileName);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
