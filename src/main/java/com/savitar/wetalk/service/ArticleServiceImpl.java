package com.savitar.wetalk.service;

import com.savitar.wetalk.dao.*;
import com.savitar.wetalk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;


import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticlePictureRepository articlePictureRepository;

    @Autowired
    private PraiseRepository praiseRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReplyRepository replyRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
    public Article addTransmitArticle(Article article) {
        return articleRepository.save(article);
    }
    public Page<Article> getAllArticles(Pageable pageable) {
        int currentId = (int)session.getAttribute("userId");
        Page<Article> list = articleRepository.findAllArticles(pageable);
        list.forEach(article -> {
            List<ArticlePicture> articlePicture = articlePictureRepository.getArticlePictures(article.getId());
            List<ArticlePicture> transmitPicture = articlePictureRepository.getArticlePictures(article.getTransmit_id());
            Praise praise = praiseRepository.findByArticle_idAndUser_id(article.getId(), currentId);
            if(praise == null)
                article.setPraise_state(0);
            else
                article.setPraise_state(praise.getPraise_state());
            article.setArticlePicture(articlePicture);
            article.setTransmitPicture(transmitPicture);
        });
        return list;
    }

    public Article getArticleDetail(int id, Pageable pageable) {
        int currentId = (int)session.getAttribute("userId");
        Article article = articleRepository.findById(id);
        List<ArticlePicture> transmitPicture = articlePictureRepository.getArticlePictures(article.getTransmit_id());
        Praise praise = praiseRepository.findByArticle_idAndUser_id(article.getId(), currentId);
        article.setArticlePicture(articlePictureRepository.getArticlePictures(id));
        article.setComments(commentRepository.findByComment_id(id, pageable));
        Page<Comment> comments = article.getComments();
        comments.forEach(comment -> {
            List<Reply> replies = replyRepository.findByReply_id(comment.getId());
            comment.setReplies(replies);
        });
        if(praise == null)
            article.setPraise_state(0);
        else
            article.setPraise_state(praise.getPraise_state());
        article.setTransmitPicture(transmitPicture);
        return article;
    }

    @Override
    public void praise(int id, int praiseCount) {
        articleRepository.updateArticleByPraiseCount(id, praiseCount);
    }
}
