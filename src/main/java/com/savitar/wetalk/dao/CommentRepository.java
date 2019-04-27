package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(nativeQuery = true, value = "select * from comment where comment_id = ?1 order by comment_time desc")
    Page<Comment> findByComment_id(int id, Pageable pageable);

    @Query(nativeQuery = true, value = "update comment set comment_user_head=?2 where comment_user_id=?1")
    @Transactional
    @Modifying
    void updateCommentUserHeadByUserId(int id, String filename);

    void deleteById(int id);

    @Query(nativeQuery = true, value = "update comment set comment_user=?2 where comment_user_id=?1")
    @Transactional
    @Modifying
    void updateCommentUserByUserId(int id, String nickname);

}
