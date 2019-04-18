package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query(nativeQuery = true, value = "select * from reply where reply_id = ?1")
    List<Reply> findByReply_id(int id);
}
