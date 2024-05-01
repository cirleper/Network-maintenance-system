package com.leaves.pagehelpertest.util;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private final JavaMailSender javaMailSender;

    public EmailUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVerificationCode(String receiveEmailName, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("508425827@qq.com");
        message.setTo(receiveEmailName);
        message.setSubject("Your Verification Code");
        message.setText("Your verification code is: " + verificationCode);
        javaMailSender.send(message);
    }
}
