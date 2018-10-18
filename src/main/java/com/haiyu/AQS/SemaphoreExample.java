package com.haiyu.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: SemaphoreExample
 * @Description: Semaphore
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/18 11:22
 */
@Slf4j
public class SemaphoreExample {

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int index = 0; index < threadCount ; index++){
            final int threadNum = index+1 ;
            exec.execute(() -> {
                try {
                    semaphore.acquire();//获取一个许可
                    test(threadNum);
                    semaphore.release();//释放一个许可
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum)throws Exception{
        Thread.sleep(100);
        log.info("{}",threadNum);
    }
}
