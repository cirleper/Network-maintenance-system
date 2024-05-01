package com.leaves.pagehelpertest.service.impl;

import com.leaves.pagehelpertest.common.ResponseMsg;
import com.leaves.pagehelpertest.dao.UserBindingAccountDao;
import com.leaves.pagehelpertest.dao.UserDao;
import com.leaves.pagehelpertest.model.dox.UserDo;
import com.leaves.pagehelpertest.model.vo.UserInfoVo;
import com.leaves.pagehelpertest.service.AuthenticationService;
import com.leaves.pagehelpertest.util.EmailUtil;
import com.leaves.pagehelpertest.util.GenerateVerificationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBindingAccountDao userBindingAccountDao;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private GenerateVerificationUtil generateVerificationUtil;


    public ResponseMsg<?> login(String userName, String password) {
        UserDo userDo=userDao.selectUserByNameAndPassword(userName,password);
        UserInfoVo userInfoVo=new UserInfoVo();
        userInfoVo.setId(userDo.getUserId());
        userInfoVo.setUserName(userDo.getUserName());
        userInfoVo.setGid(userDo.getGid());
        userInfoVo.setCoded(userDo.getCoded());
        if(userDo==null){
            return ResponseMsg.error(404,"不存在该用户");
        }
        if(Integer.parseInt(userDao.selectCodeByUserName(userName))!=1){
            System.out.println("405");
            return ResponseMsg.error(405,"该账号未激活！");
        }
        return ResponseMsg.success(userInfoVo);
    }

    @Override
    public ResponseMsg<?> verfiyActivate(String email, String inToVerfiyCode) {
        try {
            Integer userId = userBindingAccountDao.getUserIdByEmail(email);
            String dbVerfiyCode = userDao.getVerfiyCodeByUserId(userId);
            if (dbVerfiyCode.equals(inToVerfiyCode)) {
                userDao.updateVerfiyCode(userId);
                return ResponseMsg.success("verfiy success");
            } else {
                return ResponseMsg.error(600, "verfiy error");
            }
        } catch (Exception e) {
            log.error("Failed to verify activation for email: " + email, e);
            return ResponseMsg.error(500, "Failed to verify activation. Please try again later.");
        }
    }

    @Override
    public ResponseMsg<?> register(String userName, String password, String email) {
        try {
            // 验证用户名&邮箱唯一性
            if(userDao.selectSameUserNameCount(userName)>=1){
                return ResponseMsg.error(201,"The customer that you input were already registered");
            }
            if(userBindingAccountDao.selectSameEmailCount(email)>=1){
                return ResponseMsg.error(202,"The email that you input were already registered");
            }

            // 生成验证码
            String verificationCode=generateVerificationUtil. generateVerificationCode();
            // 插入注册的相关信息
            userDao.insert(userName,password,verificationCode);
            // 由用户名获取该用户在数据库中的user_id以插入账号绑定的相关信息。
            UserDo userDo=userDao.selectUserByUserName(userName);
            userBindingAccountDao.insertToRegister(userDo.getUserId(),email);

            // 发送验证码的相关逻辑
            emailUtil.sendVerificationCode(email, verificationCode);

            // 记录成功发送验证码的日志
            log.info("Verification code sent successfully to " + email);

            return  ResponseMsg.createSuccess("Verification code sent successfully.");
        } catch (Exception e) {
            // 记录发送验证码失败的日志
            log.error("Failed to send verification code to " + email, e);
            return  ResponseMsg.error(401,"Failed to send verification code. Please try again later.");
        }
    }
}
