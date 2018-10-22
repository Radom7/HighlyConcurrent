package com.haiyu.atomic;

import com.haiyu.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Title: CountExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/8/23 10:02
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal ; index++){
            exec.execute(() -> {
                try{
                    semaphore.acquire();
                    test();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
        log.info("isHappened:{}",isHappened.get());
    }

    private static void test(){
        if (isHappened.compareAndSet(false, true)) {
            log.info("execute");
        }
    }

}
