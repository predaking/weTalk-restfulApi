package com.savitar.wetalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.savitar.wetalk.annotation.LoginRequired;
import com.savitar.wetalk.dao.UserRepository;
import com.savitar.wetalk.entity.User;
import com.savitar.wetalk.service.AuthenticationService;
import com.savitar.wetalk.service.UserService;
import com.savitar.wetalk.util.FileUtil;
import com.savitar.wetalk.util.ResponseResult;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private HttpSession session;

    @LoginRequired
    @GetMapping("/ttt")
    public String testLogin() {
        return "--success--";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseResult addUser(@RequestBody User user) {
        if(userService.addUser(user)) {
            User userIndataBase = userRepository.findByNickname(user.getNickname());
            String token = authenticationService.getToken(userIndataBase);
//            user = userRepository.getOne(user.getId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            session.setAttribute("userId", userIndataBase.getId());
            System.out.println(session.getAttribute("userId"));
            return RetResponse.makeRsp(200, "注册成功", jsonObject);
        }
        else
            return RetResponse.makeRsp(-1, "该用户名已被占用");
    }

    @RequestMapping(value="/changeHead", method = RequestMethod.POST)
    public ResponseResult changeHead(@RequestParam("file") MultipartFile file, String nickname) {
        System.out.println(nickname);
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\weTalkImages\\";
        System.out.println(fileName);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            userRepository.changeHead(nickname, fileName);
        } catch (Exception e) {
            return RetResponse.makeRsp(-1, "上传失败", e);
        }
        return RetResponse.makeRsp(200, "上传成功", fileName);
//        return RetResponse.makeOKRsp();
    }
}
