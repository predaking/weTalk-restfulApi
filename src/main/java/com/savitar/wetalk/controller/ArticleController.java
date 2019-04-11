package com.savitar.wetalk.controller;

import com.savitar.wetalk.dao.ArticlePictureRepository;
import com.savitar.wetalk.entity.Article;
import com.savitar.wetalk.service.ArticleService;
import com.savitar.wetalk.util.FileUtil;
import com.savitar.wetalk.util.ResponseResult;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticlePictureRepository articlePictureRepository;


    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ResponseResult addArticle(@RequestParam("files") MultipartFile[] files, Article article) {
        System.out.println(article);
        Article newArticle = articleService.addArticle(article);
        int currentId = newArticle.getId();
        System.out.println(files.length);
        String filePath = "E:\\weTalkImages\\";
        try {
            for(int i=0; i < files.length; i++) {
                String fileName = files[i].getOriginalFilename();
                System.out.println(fileName);
                FileUtil.uploadFile(files[i].getBytes(), filePath, fileName);
                articlePictureRepository.publishArticlePictures(currentId, fileName);
            }
        } catch (Exception e) {
            return RetResponse.makeRsp(-1, "上传失败", e);
        }
        return RetResponse.makeRsp(200, "上传成功", article);
    }

    @RequestMapping(value = "/articleList", method = RequestMethod.GET)
    public ResponseResult articleList() {
        List<Article> allArticles = articleService.getAllArticles();
        return RetResponse.makeRsp(200, "请求成功", allArticles);
    }
}
