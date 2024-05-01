package com.leaves.pagehelpertest.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateTokenUtil {
//    public String generateToken(String userName){
//        long expirationTime=3600000;
//        long currentTimeMillis=System.currentTimeMillis();
//        Date expiration = new Date(currentTimeMillis + expirationTime);
//
//        // 生成令牌
//        String token = Jwts.builder()
//                .setSubject(userName)
//                .setExpiration(expiration)
//                .signWith(SignatureAlgorithm.HS512, "secret_key") // 使用HS512算法和密钥进行签名
//                .compact();
//
//        return token;
//    }
}
