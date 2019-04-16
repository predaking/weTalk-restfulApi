package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query(nativeQuery = true, value = "update article set praise_count=?2 where id=?1")
    @Modifying
    @Transactional
    void updateArticleByPraiseCount(int id, int praiseCount);

    @Query(nativeQuery = true, value = "select * from article order by publish_time desc")
    List<Article> findAllArticles();
}
