package com.haiyu.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Title: CountDownLatchExample
 * @Description: CountDownLatch
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/18 11:17
 */
@Slf4j
public class CountDownLatchExample2 {

    private static int threadCount = 200;


    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int index = 0; index < threadCount ; index++){
            final int threadNum = index+1 ;
            exec.execute(() -> {
                try {
                    test(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }finally {
                    //保障执行
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum)throws Exception{
        Thread.sleep(100);
        log.info("{}",threadNum);
    }

}
