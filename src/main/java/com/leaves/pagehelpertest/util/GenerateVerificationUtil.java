package com.leaves.pagehelpertest.util;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class GenerateVerificationUtil {
    public String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000; // 生成100000到999999之间的随机数
        return String.valueOf(code);
    }
}
