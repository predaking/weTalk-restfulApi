package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Praise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PraiseRepository extends JpaRepository<Praise, Integer> {

    @Query(nativeQuery = true, value = "select * from praise where article_id = ?1 and user_id = ?2")
    Praise findByArticle_idAndUser_id(int aid, int uid);

    @Query(nativeQuery = true, value = "insert praise(article_id, user_id, praise_state) values (?1, ?2, ?3) on duplicate key update article_id = ?1, user_id = ?2, praise_state = ?3")
    @Transactional
    @Modifying
    void updatePraise_state(int article_id, int user_id, int praise_state);
}
