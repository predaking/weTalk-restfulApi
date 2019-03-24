package com.savitar.wetalk.service;

import com.savitar.wetalk.entity.User;
import com.savitar.wetalk.util.ResponseResult;

public interface UserService {
    boolean addUser(User user);
    boolean comparePassword(User user, User userIndataBase);
}
