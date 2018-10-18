package com.haiyu.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Title: FutureExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/18 14:26
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception{
        FutureTask<String> futureTask = new FutureTask <String>(new Callable <String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });
        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result:{}",result);

    }

}
