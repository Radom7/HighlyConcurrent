package com.haiyu.syncContainer;

import com.haiyu.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;


import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: ArrayListExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 16:40
 */
@Slf4j
@ThreadSafe
public class VectorExample1 {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal ; index++){
            int count = index;
            exec.execute(() -> {
                try{
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
        log.info("size:{}",list.size());
    }

    private static void update(int i){
        list.add(i);
    }
}
