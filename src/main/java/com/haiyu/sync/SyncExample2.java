package com.haiyu.sync;

import lombok.extern.slf4j.Slf4j;

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
public class SyncExample2 {

    //修改一个类 作用于所有对象
    public void test1(int j){
        synchronized (SyncExample2.class){
            for (int i =0 ;i<10;i++){
                log.info("test1 {} - {}",j,i);
            }
        }
    }

    //修饰一个static方法 作用于所有对象
    public static synchronized void test2(int j){
        for (int i =0 ;i<10;i++){
            log.info("test2 {} - {}",j,i);
        }
    }

    public static void main(String[] args) {
        SyncExample2 syncExample =  new SyncExample2();
        SyncExample2 syncExample2 =  new SyncExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test1(1);
        });
        executorService.execute(() -> {
            syncExample2.test1(2);
        });
    }

}
