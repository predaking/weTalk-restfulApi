package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Article;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query(nativeQuery = true, value = "update article set head=?2 where user_id=?1")
    @Transactional
    @Modifying
    void updateArticleHeadByUserId(int id, String filename);

    @Query(nativeQuery = true, value = "update article set nickname=?2 where user_id=?1")
    @Transactional
    @Modifying
    void updateArticleUserByUserId(int id, String nickname);

    @Query(nativeQuery = true, value = "update article set praise_count=?2 where id=?1")
    @Modifying
    @Transactional
    void updateArticleByPraiseCount(int id, int praiseCount);

    @Query(nativeQuery = true, value = "update article set transmit_count=?2 where id=?1")
    @Modifying
    @Transactional
    void updateArticleByTransmitCount(int id, int praiseCount);

    @Query(nativeQuery = true, value = "update article set comment_count=?2 where id=?1")
    @Modifying
    @Transactional
    void updateArticleByCommentCount(int id, int praiseCount);

    Article findById(int id);

    @Query(nativeQuery = true, value = "select * from article order by publish_time desc")
    Page<Article> findAllArticles(Pageable pageable);

    void deleteById(int id);

}
