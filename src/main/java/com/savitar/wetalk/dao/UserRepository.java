package com.savitar.wetalk.dao;

import com.savitar.wetalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNickname(String nickname);
}
