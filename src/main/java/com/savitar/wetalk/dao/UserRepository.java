package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNickname(String nickname);

    User findById(int id);

    @Query(nativeQuery = true, value = "update user set head=?2 where id=?1")
    @Modifying
    @Transactional
    void changeHead(int id, String filename);

}
