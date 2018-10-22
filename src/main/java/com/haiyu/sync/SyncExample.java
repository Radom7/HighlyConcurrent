package com.haiyu.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: SyncExample
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/10/22 12:03
 */
@Slf4j
public class SyncExample {

    //修改一个代码块 作用于调用的对象，不同对象调用之间互不影响
    public void test1(int j){
        synchronized (this){
            for (int i =0 ;i<10;i++){
                log.info("test1 {} - {}",j,i);
            }
        }
    }

    //修饰一个方法 作用于调用的对象
    public synchronized void test2(){
        for (int i =0 ;i<10;i++){
            log.info("test2 - {}",i);
        }
    }

    public static void main(String[] args) {
        SyncExample syncExample =  new SyncExample();
        SyncExample syncExample2 =  new SyncExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test1(1);
        });
        executorService.execute(() -> {
            syncExample2.test1(2);
        });
    }

}
