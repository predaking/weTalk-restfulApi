package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query(nativeQuery = true, value = "select * from reply where reply_id = ?1")
    List<Reply> findByReply_id(int id);

    @Query(nativeQuery = true, value = "update reply set reply_user=?2 where reply_user_id=?1")
    @Transactional
    @Modifying
    void updateReplyUserByReplyUserId(int id, String nickname);


    @Query(nativeQuery = true, value = "delete from reply where reply_id=?1")
    @Transactional
    @Modifying
    void deleteByReply_id(int id);

    void deleteById(int id);
}
