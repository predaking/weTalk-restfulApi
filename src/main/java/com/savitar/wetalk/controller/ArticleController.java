package com.savitar.wetalk.controller;

import com.savitar.wetalk.entity.Article;
import com.savitar.wetalk.service.ArticleService;
import com.savitar.wetalk.util.ResponseResult;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
//    , @RequestParam("file") MultipartFile file
    public ResponseResult addArticle(@RequestBody Article article) {
        Article newArticle = articleService.addArticle(article);
//        articleService.addArticlePicture(newArticle.getId(), file);
        return RetResponse.makeRsp(200, "成功", newArticle);
    }
}
