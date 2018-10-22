package com.haiyu.count;

import com.haiyu.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: CountExample
 * @Description: volatile不具有原子性
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 10:02
 */
@Slf4j
@UnThreadSafe
public class CountExample4 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private volatile static long count = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal ; index++){
            exec.execute(() -> {
                try{
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}",count);
    }

    private static void add(){
        count++;
        //1. count
        //2. +1
        //3. count
    }

}
