package com.leaves.pagehelpertest.controller;

import com.leaves.pagehelpertest.common.ResponseMsg;
import com.leaves.pagehelpertest.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
//@CrossOrigin(origins = "http://localhost:8080")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseMsg<?>login(String userName,String password){
        System.out.println("userName = " + userName);
        System.out.println("password="+password);
        return authenticationService.login(userName,password);
    }

    @PostMapping("/register")
    public ResponseMsg<?> register(String userName,String password,String email) {
       return  authenticationService.register(userName,password,email);
    }

    @PostMapping("verfiy-activation")
    public ResponseMsg<?>verfiyActivate(String email,String verfiyCode){
        System.out.println("email = " + email);
        System.out.println(verfiyCode);
        return authenticationService.verfiyActivate(email,verfiyCode);
    }
}
