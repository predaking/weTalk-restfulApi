package com.savitar.wetalk.controller;

import com.savitar.wetalk.annotation.LoginRquired;
import com.savitar.wetalk.entity.User;
import com.savitar.wetalk.service.UserService;
import com.savitar.wetalk.util.ResponseResult;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @LoginRquired
    @GetMapping("/ttt")
    public String testLogin() {
        return "success";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseResult<User> addUser(@RequestBody User user) {
        System.out.println(user);
        if(userService.addUser(user)) {
            return RetResponse.makeOKRsp();
        }
        else
            return RetResponse.makeRsp(-1, "该用户名已被占用");
    }
}
