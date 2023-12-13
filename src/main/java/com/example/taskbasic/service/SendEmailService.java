package com.example.taskbasic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author ftz
 * 创建时间:12/12/2023 下午7:34
 * 描述: TODO
 */
@Service
public class SendEmailService {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Value("2179732328@qq.com")
    private String sender;
    @Async
    public void sendEmail(String receiver,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            System.out.println("发送成功");
        }catch (Exception e){
            System.out.println("发送失败");
            e.printStackTrace();
        }
    }
    @Async
    public void sendTemplateEmail(String receiver, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            System.out.println("发送成功");
        }catch (Exception e){
            System.out.println("发送失败");
            e.printStackTrace();
        }


    }
}
