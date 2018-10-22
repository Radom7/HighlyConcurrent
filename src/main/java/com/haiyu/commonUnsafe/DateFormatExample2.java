package com.haiyu.commonUnsafe;

import com.haiyu.annoations.ThreadSafe;
import com.haiyu.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: DateExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 16:17
 */
@Slf4j
@ThreadSafe
public class DateFormatExample2 {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

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
    }

    private static void update(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180228");
        }catch (Exception e){
            log.error("parse exception",e);
        }
    }
}
