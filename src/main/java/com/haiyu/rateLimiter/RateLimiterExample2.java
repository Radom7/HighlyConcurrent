package com.haiyu.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Title: RateLimiterExample
 * @Description: 限流
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/20 10:22
 */
@Slf4j
public class RateLimiterExample2 {

    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) throws Exception {
        for (int index = 0; index <100 ;index++){
            rateLimiter.acquire();//所有请求都能执行 ，需要等待获取令牌
            handle(index);
        }
    }

    private static void handle(int i){
        log.info("{}",i);
    }
}
