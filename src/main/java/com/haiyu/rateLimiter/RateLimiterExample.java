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
public class RateLimiterExample {

    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) throws Exception {
        for (int index = 0; index <100 ;index++){
            //等待200毫秒
            if(rateLimiter.tryAcquire(200, TimeUnit.MILLISECONDS)){
                handle(index);
            }

        }
    }

    private static void handle(int i){
        log.info("{}",i);
    }
}
