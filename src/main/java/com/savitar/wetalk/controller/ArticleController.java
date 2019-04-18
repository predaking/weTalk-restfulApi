package com.savitar.wetalk.controller;

import com.savitar.wetalk.dao.*;
import com.savitar.wetalk.entity.*;
import com.savitar.wetalk.service.ArticleService;
import com.savitar.wetalk.util.FileUtil;
import com.savitar.wetalk.util.ResponseResult;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticlePictureRepository articlePictureRepository;

    @Autowired
    private PraiseRepository praiseRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ResponseResult publish(@RequestParam("files") MultipartFile[] files, Article article) {
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
            return RetResponse.makeRsp(200, "上传成功", article);
        } catch (Exception e) {
            return RetResponse.makeRsp(-1, "上传失败", e);
        }
    }

    @RequestMapping(value = "/articleList", method = RequestMethod.GET)
    public ResponseResult articleList() {
        List<Article> allArticles = articleService.getAllArticles();
        return RetResponse.makeRsp(200, "请求成功", allArticles);
    }

    @RequestMapping(value = "/praise", method = RequestMethod.POST)
    public ResponseResult praise(@RequestParam Integer id, @RequestParam Integer praiseCount, @RequestParam Integer praiseState) {
        articleService.praise(id, praiseCount);
        praiseRepository.updatePraise_state(id, (int)session.getAttribute("userId"), praiseState);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/transmit", method = RequestMethod.POST)
    public ResponseResult transmit(@RequestBody Article article) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            df.format(article.getPublish_time());
            System.out.println("++" + article.getPublish_time() + "++");
            articleService.addTransmitArticle(article);
            int oldTransmitCount = articleRepository.findById(article.getTransmit_id()).getTransmit_count();
            articleRepository.updateArticleByTransmitCount(article.getTransmit_id(), ++oldTransmitCount);
            return RetResponse.makeRsp(200, "转发成功", article);
        } catch (Exception e) {
            return RetResponse.makeRsp(-1, "转发失败", e);
        }
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseResult detail(@RequestParam int id) {
        try {
            Article article = articleService.getArticleDetail(id);
            return RetResponse.makeRsp(200, "success", article);
        } catch (Exception e) {
            return RetResponse.makeRsp(-1, "error", e);
        }
    }

}
