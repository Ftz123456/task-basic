package com.example.taskbasic.controller;

import cn.hutool.core.util.RandomUtil;
import com.example.taskbasic.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;


import org.thymeleaf.context.Context;


/**
 * @author ftz
 * 创建时间:12/12/2023 下午7:46
 * 描述: TODO
 */
@RestController
public class EmailController {
    @Autowired
    private SendEmailService sendEmailService;
    @GetMapping("/sendEmail")
    public String sendEmail() {
        String receiver = "2960252003@qq.com";
        String subject = "测试邮件";
        String luckCode = RandomUtil.randomNumbers(5);
        String content = "您的验证码是：" + luckCode;
        sendEmailService.sendEmail(receiver, subject, content);
        return "发送成功";
    }
    @Autowired
    TemplateEngine templateEngine;
    @GetMapping("/sendTemplateEmail")
    public String sendTemplateEmail() {
        String receiver = "485913144@qq.com";
        String subject = "测试邮件";
        //djushfuhasuhuash
       Context context = new Context();
        context.setVariable("username", "ftz");
        context.setVariable("code", RandomUtil.randomNumbers(5));
         String content = templateEngine.process("emailTemplate.html", context);
        sendEmailService.sendTemplateEmail(receiver, subject, content);
         return "发送成功";



}}
