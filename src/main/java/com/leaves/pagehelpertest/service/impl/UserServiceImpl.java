package com.leaves.pagehelpertest.service.impl;

import com.leaves.pagehelpertest.common.ResponseMsg;
import com.leaves.pagehelpertest.dao.UserBindingAccountDao;
import com.leaves.pagehelpertest.dao.UserDao;
import com.leaves.pagehelpertest.model.dox.UserDo;
import com.leaves.pagehelpertest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBindingAccountDao userBindingAccountDao;
    public ResponseMsg<?>selectUserInformation(){
        List<UserDo> userDos=userDao.selectUserInformation();
        for(UserDo userDo :userDos){
            System.out.println(userDo.getUserName());
        }
        System.out.println();
        return  ResponseMsg.success(userDos);
    }
    public ResponseMsg<?>updateUserInfo(String userId,String userName,String password,String coded,String gid){
        Integer user_id=Integer.parseInt(userId);
        Integer updateFlag=userDao.updateUserInfo(user_id,userName,password,coded,Integer.parseInt(gid));
        System.out.println(updateFlag);
        if(updateFlag==1){
            return ResponseMsg.success("update success");
        }else{
            return ResponseMsg.error(404,"update failed");
        }
    }

    public ResponseMsg<?>deleteUserInfo(String userId){
        Integer user_id=Integer.parseInt(userId);
        Integer deleteBindingAccountFlag=userBindingAccountDao.deleteBindingAccountByUserId(user_id);
        Integer deleteUserInfoFlag=userDao.deleteUserInfoByUserId(user_id);
        if(deleteUserInfoFlag==1&&deleteBindingAccountFlag==1){
            return ResponseMsg.success("delete success");
        }else{
            return ResponseMsg.error(404,"detele dailed");
        }
    }

}
