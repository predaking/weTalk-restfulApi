package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNickname(String nickname);

    @Query(nativeQuery = true, value = "update user set head=?2 where nickname=?1")
    @Modifying
    @Transactional
    void changeHead(String nickname, String filename);
}
