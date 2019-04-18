package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(nativeQuery = true, value = "select * from comment where comment_id = ?1")
    List<Comment> findByComment_id(int id);
}
