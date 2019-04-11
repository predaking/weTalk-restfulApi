package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.ArticlePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticlePictureRepository extends JpaRepository<ArticlePicture, Integer> {

    @Query(nativeQuery = true, value = "insert into article_picture (picture_id, picture_url) values (?1, ?2)")
    @Modifying
    @Transactional
    void publishArticlePictures(int id, String filename);

    @Query(nativeQuery = true, value = "select * from article_picture where picture_id = ?1")
    List<ArticlePicture> getArticlePictures(int id);
}
