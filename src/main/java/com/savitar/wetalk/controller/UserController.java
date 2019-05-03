package com.savitar.wetalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.savitar.wetalk.dao.ArticleRepository;
import com.savitar.wetalk.dao.CommentRepository;
import com.savitar.wetalk.dao.ReplyRepository;
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

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseResult addUser(@RequestBody User user) {
        if(userService.addUser(user)) {
            User userIndataBase = userRepository.findByNickname(user.getNickname());
            String token = authenticationService.getToken(userIndataBase);
//            user = userRepository.getOne(user.getId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            session.setAttribute("userId", userIndataBase.getId());
            jsonObject.put("user_id", userIndataBase.getId());
            System.out.println(session.getAttribute("userId"));
            return RetResponse.makeRsp(200, "注册成功", jsonObject);
        }
        else
            return RetResponse.makeRsp(-1, "该用户名已被占用");
    }

    @RequestMapping(value = "/api/authentication",method = RequestMethod.POST)
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

    @RequestMapping(value="/changeHead", method = RequestMethod.POST)
    public ResponseResult changeHead(@RequestParam("file") MultipartFile file, Integer id) {
        System.out.println("--" + id + "--");
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\weTalkImages\\";
        System.out.println(fileName);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            userRepository.changeHead(id, fileName);
            articleRepository.updateArticleHeadByUserId(id, fileName);
            commentRepository.updateCommentUserHeadByUserId(id, fileName);
            return RetResponse.makeRsp(200, "上传成功", fileName);
        } catch (Exception e) {
            return RetResponse.makeRsp(-1, "上传失败", e);
        }
    }

    @RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
    public ResponseResult changeInfo(@RequestBody User user) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        df.format(user.getBirthday());
        User oldUser = userRepository.findById(user.getId());
        oldUser.setNickname(user.getNickname());
        oldUser.setAddress(user.getAddress());
        oldUser.setBirthday(user.getBirthday());
        oldUser.setSex(user.getSex());
        userRepository.saveAndFlush(oldUser);
        articleRepository.updateArticleUserByUserId(user.getId(), user.getNickname());
        commentRepository.updateCommentUserByUserId(user.getId(), user.getNickname());
        replyRepository.updateReplyUserByReplyUserId(user.getId(), user.getNickname());
        return RetResponse.makeOKRsp();
    }

}
