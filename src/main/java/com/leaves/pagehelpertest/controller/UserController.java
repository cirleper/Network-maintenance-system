package com.leaves.pagehelpertest.controller;

import com.leaves.pagehelpertest.common.ResponseMsg;
import com.leaves.pagehelpertest.service.UserService;
import com.leaves.pagehelpertest.service.impl.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/info")
    public ResponseMsg<?>selectUserInformation(){
        return userService.selectUserInformation();
    }

    @PostMapping (value="/delete")
    public ResponseMsg<?>deleteUserInfo(String userId){
        return userService.deleteUserInfo(userId);
    }

    @PostMapping(value="/update")
    public ResponseMsg<?>updateUserInfo(String userId,String userName,String password,String coded,String gid){
        System.out.println(userId+userName+password+coded+gid);
        return userService.updateUserInfo(userId,userName, password,coded,gid);
    }

}
