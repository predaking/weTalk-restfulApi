package com.savitar.wetalk.service;

import com.savitar.wetalk.dao.ArticlePictureRepository;
import com.savitar.wetalk.dao.ArticleRepository;
import com.savitar.wetalk.dao.PraiseRepository;
import com.savitar.wetalk.dao.UserRepository;
import com.savitar.wetalk.entity.Article;
import com.savitar.wetalk.entity.ArticlePicture;
import com.savitar.wetalk.entity.Praise;
import com.savitar.wetalk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;


    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
    public List<Article> getAllArticles() {
        int currentId = (int)session.getAttribute("userId");
        System.out.println(session.getAttribute("userId"));
        List<Article> list = articleRepository.findAllArticles();
        list.forEach(article -> {
            List<ArticlePicture> articlePicture = articlePictureRepository.getArticlePictures(article.getId());
            Praise praise = praiseRepository.findByArticle_idAndUser_id(article.getId(), currentId);
            User user = userRepository.findById(currentId);
            System.out.println(article.getId() + "++" + praise + "++" + currentId);
            if(praise == null)
                article.setPraise_state(0);
            else
                article.setPraise_state(praise.getPraise_state());
            article.setNickname(user.getNickname());
            article.setHead(user.getHead());
            article.setArticlePicture(articlePicture);
        });
        return list;
    }

    @Override
    public void praise(int id, int praiseCount) {
        articleRepository.updateArticleByPraiseCount(id, praiseCount);
    }
}
