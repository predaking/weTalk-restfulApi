package com.savitar.wetalk.controller;

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
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @LoginRequired
    @GetMapping("/ttt")
    public String testLogin() {
        return "--success--";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseResult addUser(@RequestBody User user) {
//        ResponseResult<User> responseResult = new ResponseResult<User>();
        if(userService.addUser(user)) {
            User userIndataBase = userRepository.findByNickname(user.getNickname());
            String token = authenticationService.getToken(userIndataBase);
            return RetResponse.makeRsp(200, "", token);
        }
        else
            return RetResponse.makeRsp(-1, "该用户名已被占用");
    }

    @RequestMapping(value="/changeHead", method = RequestMethod.POST)
    public ResponseResult changeHead(@RequestParam("file") MultipartFile file, String nickName) {
        System.out.println(file + nickName);
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "/img/";
        System.out.println(fileName);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {

        }
        return RetResponse.makeRsp(200, "上传成功", filePath+fileName);
//        return RetResponse.makeOKRsp();
    }
}
