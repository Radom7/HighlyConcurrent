package com.haiyu.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Title: CyclicBarrierExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/18 12:00
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0 ;i < 10 ; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum)throws Exception{
        Thread.sleep(1000);
        log.info("{} id ready",threadNum);
        try {
            barrier.await(2, TimeUnit.SECONDS);
        }catch (Exception e){
            log.warn("BrokenBarrierException",e);
        }

        log.info("{} continue",threadNum);
    }

}
