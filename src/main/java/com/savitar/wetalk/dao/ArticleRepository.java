package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
