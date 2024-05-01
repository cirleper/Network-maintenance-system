package com.leaves.pagehelpertest.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBindingAccountDao {
    Integer insertToRegister(Integer userId,String mailAccount);

    Integer selectSameEmailCount(String mailAccount);
    Integer getUserIdByEmail(String email);

    Integer deleteBindingAccountByUserId(Integer userId);
}
