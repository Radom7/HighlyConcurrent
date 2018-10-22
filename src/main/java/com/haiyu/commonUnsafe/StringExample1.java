package com.haiyu.commonUnsafe;

import com.haiyu.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: StringExample1
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 16:09
 */
@Slf4j
@UnThreadSafe
public class StringExample1 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal ; index++){
            exec.execute(() -> {
                try{
                    semaphore.acquire();
                    update();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}",stringBuilder.length());
    }

    private static void update(){
        stringBuilder.append("1");
    }
}
