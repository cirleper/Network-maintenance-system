package com.leaves.pagehelpertest.service;

import com.leaves.pagehelpertest.common.ResponseMsg;

public interface AuthenticationService {
    public ResponseMsg<?>login(String userName,String password);
    public ResponseMsg<?> verfiyActivate(String email,String verfiyCode);
    public ResponseMsg<?> register(String userName,String password,String email);
}
