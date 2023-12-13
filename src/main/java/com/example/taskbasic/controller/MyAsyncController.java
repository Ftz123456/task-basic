package com.example.taskbasic.controller;

import com.example.taskbasic.service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ftz
 * 创建时间:12/12/2023 下午7:21
 * 描述: TODO
 */
@RestController
public class MyAsyncController {
    @Autowired
    private MyAsyncService myAsyncService;
    // http://localhost:8080/sendSMS
    @GetMapping("/sendSMS")
    public String sendSMS() throws InterruptedException {
       Long start = System.currentTimeMillis();
        myAsyncService.sendSMS();
        Long end = System.currentTimeMillis();
        return "短信验证码接口调用结束，耗时：" + (end - start) + "毫秒";
    }
    //存在返回结果
    @GetMapping("/statistics")
    public String statistics() throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
      Future<Integer> future1 = myAsyncService.processA();
        Future<Integer> future2 = myAsyncService.processB();
    int total = future1.get() + future2.get();
        Long end = System.currentTimeMillis();
        return "统计接口调用结束，耗时：" + (end - start) + "毫秒"+total;
    }
}
