package com.savitar.wetalk.controller;

import com.savitar.wetalk.annotation.LoginRequired;
import com.savitar.wetalk.dao.*;
import com.savitar.wetalk.entity.*;
import com.savitar.wetalk.service.ArticleService;
import com.savitar.wetalk.util.FileUtil;
import com.savitar.wetalk.util.ResponseResult;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReplyRepository replyRepository;

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
    public ResponseResult articleList(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "publish_time");
            PageRequest pageable = PageRequest.of(page, size);
            Page<Article> allArticles = articleService.getAllArticles(pageable);
            return RetResponse.makeRsp(200, "请求成功", allArticles);
    }

    @RequestMapping(value = "/commentList", method = RequestMethod.GET)
    public ResponseResult commentList(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size, @RequestParam("comment_id") int comment_id) {
            PageRequest pageable = PageRequest.of(page, size);
            Page<Comment> allComments = commentRepository.findByComment_id(comment_id, pageable);
            allComments.forEach(comment -> {
            List<Reply> replies = replyRepository.findByReply_id(comment.getId());
            comment.setReplies(replies);
        });
            return RetResponse.makeRsp(200, "查询成功", allComments);
    }

    @RequestMapping(value = "/praise", method = RequestMethod.POST)
    public ResponseResult praise(@RequestParam Integer id, @RequestParam Integer praiseCount, @RequestParam Integer praiseState) {
        articleService.praise(id, praiseCount);
        praiseRepository.updatePraise_state(id, (int)session.getAttribute("userId"), praiseState);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/transmit", method = RequestMethod.POST)
    public ResponseResult transmit(@RequestBody Article article) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            df.format(article.getPublish_time());
            articleService.addTransmitArticle(article);
            int oldTransmitCount = articleRepository.findById(article.getTransmit_id()).getTransmit_count();
            articleRepository.updateArticleByTransmitCount(article.getTransmit_id(), ++oldTransmitCount);
            return RetResponse.makeRsp(200, "转发成功", article);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseResult detail(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, @RequestParam int id) {
            PageRequest pageable = PageRequest.of(page, size);
            Article article = articleService.getArticleDetail(id, pageable);
            return RetResponse.makeRsp(200, "success", article);
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public ResponseResult addComment(@RequestBody Comment comment) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            df.format(comment.getComment_time());
            int oldCommentCount = articleRepository.findById(comment.getComment_id()).getComment_count();
            articleRepository.updateArticleByCommentCount(comment.getComment_id(), ++oldCommentCount);
            commentRepository.save(comment);
            return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/addReply", method = RequestMethod.POST)
    public ResponseResult addReply(@RequestBody Reply reply) {
            replyRepository.save(reply);
            return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
    public ResponseResult deleteArticle(@RequestParam("id") int id) {
        articleRepository.deleteById(id);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public ResponseResult deleteComment(@RequestParam("id") int id, @RequestParam("comment_id") int comment_id) {
        commentRepository.deleteById(id);
        replyRepository.deleteByReply_id(id);
        int oldCommentCount = articleRepository.findById(comment_id).getComment_count();
        articleRepository.updateArticleByCommentCount(comment_id, --oldCommentCount);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/deleteReply", method = RequestMethod.POST)
    public ResponseResult deleteReply(@RequestParam("id") int id) {
        replyRepository.deleteById(id);
        return RetResponse.makeOKRsp();
    }

}
