package com.leaves.pagehelpertest.dao;

import com.leaves.pagehelpertest.model.dox.UserDo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
@Mapper
public interface UserDao {
    List<UserDo> selectUserInformation();
    UserDo selectUserByUserName(String userName);
    Integer selectSameUserNameCount(String userName);
    Integer insert(String userName,String password,String verfiyCode);
    Integer updateVerfiyCode(Integer userId);
    String getVerfiyCodeByUserId(Integer userId);
    UserDo selectUserByNameAndPassword(String userName,String password);
    String selectCodeByUserName(String userName);
    Integer updateUserInfo(Integer userId,String userName,String password,String coded,Integer gid);

    Integer deleteUserInfoByUserId(Integer userId);
}
