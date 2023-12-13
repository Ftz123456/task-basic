package com.example.taskbasic.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author ftz
 * 创建时间:12/12/2023 下午7:11
 * 描述: TODO
 */
@Service
public class MyAsyncService {
    @Async
    public void sendSMS() throws InterruptedException {
        System.out.println("调用短信验证码接口");
        Long start = System.currentTimeMillis();
        Thread.sleep(5000);
        Long end = System.currentTimeMillis();
        System.out.println("短信验证码接口调用结束，耗时：" + (end - start) + "毫秒");
    }
    @Async
    public Future<Integer>processA() throws InterruptedException {
        System.out.println("开始处理A");
        Long start = System.currentTimeMillis();
        Thread.sleep(4000);
        int result = 4000;
        Long end = System.currentTimeMillis();
        System.out.println("处理A结束，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(result);
    }
    @Async
    public Future<Integer>processB() throws InterruptedException {
        System.out.println("开始处理B");
        Long start = System.currentTimeMillis();
        Thread.sleep(3000);
        int result = 3000;
        Long end = System.currentTimeMillis();
        System.out.println("处理B结束，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(result);
    }
}
