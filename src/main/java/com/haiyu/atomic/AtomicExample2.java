package com.haiyu.atomic;

import com.haiyu.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Title: CountExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 10:02
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static AtomicLong count = new AtomicLong(0);

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
        log.info("count:{}",count.get());
    }

    private static void add(){
        count.incrementAndGet();
        //count.getAndIncrement();
    }

}
