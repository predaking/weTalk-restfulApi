package com.savitar.wetalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.savitar.wetalk.dao.UserRepository;
import com.savitar.wetalk.entity.User;
import com.savitar.wetalk.service.AuthenticationService;
import com.savitar.wetalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApi {

    @Autowired
    private AuthenticationService authenticationService;
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;


    @Autowired
    public AuthenticationApi(AuthenticationService authenticationService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public Object login(@RequestBody User user) {
        User userIndataBase = userRepository.findByNickname(user.getNickname());

        JSONObject jsonObject = new JSONObject();
        if(userIndataBase == null) {
            jsonObject.put("code", -1);
            jsonObject.put("message", "用户不存在");
        } else if(!userService.comparePassword(user, userIndataBase)) {
            jsonObject.put("code", -1);
            jsonObject.put("message", "密码不正确");
        } else {
            String token = authenticationService.getToken(userIndataBase);
            jsonObject.put("token", token);
            jsonObject.put("nickname", userIndataBase.getNickname());
            jsonObject.put("head", userIndataBase.getHead());
            jsonObject.put("user_id", userIndataBase.getId());
            session.setAttribute("userId", userIndataBase.getId());
//            System.out.println(jsonObject.get("user_id")+ "---");
        }
        return jsonObject;
    }
}
