package com.savitar.wetalk.service;

import com.savitar.wetalk.dao.UserRepository;
import com.savitar.wetalk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user) {
        User existUser = userRepository.findByNickname(user.getNickname());
        if(existUser!=null) {
            return false;
        }
        else{
            userRepository.save(user);
            return true;
        }
    }

    public boolean comparePassword(User user, User userIndataBase) {

        return user.getPassword().equals(userIndataBase.getPassword());

    }

//    public boolean changeHead(User user) {
//        return true;
//    }
}
