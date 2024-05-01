package com.leaves.pagehelpertest.service;

import com.leaves.pagehelpertest.common.ResponseMsg;


public interface UserService {
    public ResponseMsg<?> selectUserInformation();
    public ResponseMsg<?>updateUserInfo(String userId,String userName,String password,String coded,String gid);

    public ResponseMsg<?>deleteUserInfo(String userId);
}
